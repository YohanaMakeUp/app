<%@ include file="../fragments/header.jspf" %>

<script src="https:\\code.jquery.com/jquery-1.10.2.js"></script>
<!--  Proporciona el calendario , importante -->
<script src="https:\\code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<!--  Mantienen el formato actual -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css"> 

 <script>
  $(function() {
	  $( "#from" ).datepicker({
      defaultDate: "+1w",
      changeMonth: true,
      numberOfMonths: 1,
      onClose: function( selectedDate ) {
    	  $( "#to" ).datepicker( "option", "minDate", selectedDate );
      }
    });
	  $( "#to" ).datepicker({
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
    <c:when test="${not empty user}">
    <form action="registro" id="formularioRegistro" method="POST">
    
	  <label for="from">From</label>
<input type="text" id="from" name="from">
<label for="to">to</label>
<input type="text" id="to" name="to">
<input
					type="submit" value="Enviar formulario"> <input
					type="button" value="Resetear Formulario"
					onClick="this.form.reset()">
</form>
  </c:when>
   <c:otherwise>
   <h5><b>Regístrese para poder pedir una cita.</b></h5>
       </c:otherwise>
    </c:choose>
	
    </div>
  </div>
  <div style="clear:both"></div>
</div>
