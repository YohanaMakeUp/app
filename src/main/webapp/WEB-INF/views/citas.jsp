<%@ include file="../fragments/header.jspf"%>

<script src="https:\\code.jquery.com/jquery-1.10.2.js"></script>
<!--  Proporciona el calendario , importante -->
<script src="https:\\code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<!--  Mantienen el formato actual -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">



<script>
$(function() {
	$(".x").click(function(){
		var id=$(this).attr("id").substring("del_".length);
		console.log("deleting", id);
		delUser(id);
	});
});

function delUser(id) {
	$.post("delFecha", {id: id, csrf: "${e:forJavaScript(csrf_token)}"},
		function(data) {
			$("#del_"+id).parent().parent().remove();
	});
}

var diasChungos = new Array(12);

for (var i = 0; i < 12; i++) {
	
	diasChungos[i] = new Array(31);
	
 for (var j = 0; j < 31; j++) {
	
 diasChungos[i][j] = '${diasChungos.get(i).get(j).booleanValue()}'; 
 }
};
 
  $(function() {
	  
	// 	var date1 = new Date('${citasPrueba}');
	//	date1.setHours(0, 0, 0, 0);
	//	date1.setDate('${citas.get(0).getFechaIni()}');
	//	var date2 = new Date('${citasPrueba2}');
	//	date2.setHours(0, 0, 0, 0);
	//	date2.setDate('${citas.get(0).getFechaFin()}');
	
	var size = '${citas.size()}';
	  
	
	
	  $( "#from" ).datepicker({
		  
		  
		  beforeShowDay: function(date) {
	            console.log(date.getDate(), diasChungos[date.getDate()]);
	             if (diasChungos[date.getMonth()][date.getDate()]) {
	              return [true, 'muchaLuz', 'tooltipText'];
	             } else {
	                  return [false, '', 'Fallo'];
	             }
		  },
		
		  
		/*  beforeShowDay: function(date) {
			  
			  for (var index = 0; index < size; index++) {
					
					var date1 = new Date('${citas.get(index).getFechaIni()}');
					var date2 = new Date('${citas.get(index).getFechaFin()}');
				return [date <= date1 || date >= date2, ""];
				
		  }
			}
				,*/
		  
      defaultDate: "+1w",
      changeMonth: true,
      numberOfMonths: 1,
      onClose: function( selectedDate ) {
    	  $( "#to" ).datepicker( "option", "minDate", selectedDate );
      }
    });
	  

	  
	  $( "#to" ).datepicker({
		  
		  beforeShowDay: function(date) {
	          console.log(date.getDate(), diasChungos[date.getDate()]);
	          if (diasChungos[date.getMonth()][date.getDate()]) {
	           return [true, 'muchaLuz', 'tooltipText'];
	          } else {
	               return [false, '', 'Fallo'];
	          }
	        },
	     /*   beforeShowDay: function(date) {
	        	 for (var index = 0; index < size; index++) {
						
						var date1 = new Date('${citas.get(index).getFechaIni()}');
						var date2 = new Date('${citas.get(index).getFechaFin()}');
				return [date <= date1 || date >= date2, ""];
	        	 }
			},*/
		  
		  
      defaultDate: "+1w",
      changeMonth: true,
      numberOfMonths: 1,
      onClose: function( selectedDate ) {
    	  $( "#from" ).datepicker( "option", "maxDate", selectedDate );
      }
    });
	  
	
  });
  </script>
  
  
<h1 class="logo">Citas</h1>
<div id="container">
	<div class="content">
		<div id="fane1">

			<c:choose>
				<c:when test="${user.getRole() eq 'user' and  not empty user}">
					<form action="citas" id="formularioRegistro" method="POST">

						<label for="from">From</label> <input type="text" id="from"
							name="from" required> <label for="to">to</label> <input
							type="text" id="to" name="to" required> <input type="submit"
							value="Enviar formulario"> <input type="button"
							value="Resetear Formulario" onClick="this.form.reset()">
					</form>
				</c:when>				
				<c:when test="${user.getRole() eq 'Admin' and not empty user}">
				<table style="width:100%">
				<tr>
				<th> Nombre</th>
				<th> Apellido</th>
				<th> Usuario</th>
				<th> Email</th>
				<th> Desde</th>
				<th> Hasta</th>
				</tr>
				
				<c:forEach items="${citas}" var="c">
				
				<tr>
				<td>${c.user.nombre}
				<td>${c.user.apellidos}
				<td>${c.user.nombreUsuario}
				<td>${c.user.email}
				<td>${c.fechaIni}
				<td>${c.fechaFin}
				<td><button class="x" id="del_${c.id}">x</button></tr>
				</c:forEach>
				</table>
				</c:when>
				<c:otherwise>
					<h5>
						<b>Regístrese para poder pedir una cita.</b>
					</h5>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<div style="clear: both"></div>
</div>
