<%@ include file="../fragments/header.jspf" %>

<h1 class="logo">Contacto</h1>
<div id="container">
  <div class="content">
    <div id="fane1">
      <!-- Aqui va el formulario -->
	  <form>
	  <label>Nombre	</label><input id="Nombre" name ="name" type="text" placeholder="Nombre" ><br>
	  <label>Apellido	</label><input id="Nombre" name ="apellido" type="text" placeholder="Apellido"><br>
	  <label>Email  </label><input id="Nombre" name="email" type="text" placeholder="Email"><br>
	  <label>Asunto</label><br>
		<textarea id="nuevoTextoDescriptivo" name="asunto" style="resize:none;"></textarea><br>
		<input type="submit"  value="Enviar"> 
		<input type="button" value="Resetear Formulario" onClick="this.form.reset()">
	  </form>
    </div>
  </div>
  <div style="clear:both"></div>
</div>
