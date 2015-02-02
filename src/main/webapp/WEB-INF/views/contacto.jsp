<%@ include file="../fragments/header.jspf" %>

<h1 class="logo">Contacto</h1>
<div id="container">
  <div class="content">
    <div id="fane1">
      <!-- Aqui va el formulario -->
	  <form Action="mailto:robertomore9@hotmail.com?Subject=Test_Post" METHOD="POST" enctype="text/plain">
	  
	  <label>Nombre	</label><br>
	  
	 <c:choose>
    <c:when test="${not empty user}">
	  <input id="Nombre" name ="Nombre del cliente" type="text" value="${user.getNombre()}" required><br>
	     </c:when>
	     <c:otherwise>
	      <input id="Nombre" name ="Nombre del cliente" type="text" placeholder="Nombre" ><br>
	       </c:otherwise>
  </c:choose>
  
	 <label>Apellido</label><br>
	 
	   <c:choose>
    <c:when test="${not empty user}">
	  <input id="Nombre" name ="Apellido del cliente" type="text" value="${user.getApellidos()}" required><br>
	   </c:when>
	     <c:otherwise>
	     	  <input id="Nombre" name ="Apellido del cliente" type="text" placeholder="Apellido"><br>
	           </c:otherwise>
  </c:choose>
  
	  <label>Email  </label><br>
	  
	     <c:choose>
    <c:when test="${not empty user}">
    
	  <input id="Nombre" name="Email del cliente" type="email" value="${user.getEmail()}" required><br>
	   </c:when>
	     <c:otherwise>
	     
	  	  <input id="Nombre" name="Email del cliente" type="email" placeholder="Email"><br>
	     </c:otherwise>
  </c:choose>
  
	  <label>Asunto</label><br>
		<textarea id="nuevoTextoDescriptivo" name="Asunto" style="resize:none;" required></textarea><br>
		<input type="submit"  value="Enviar"> 
		<input type="button" value="Resetear Formulario" onClick="this.form.reset()">
	  </form>
    </div>
  </div>
  <div style="clear:both"></div>
</div>
