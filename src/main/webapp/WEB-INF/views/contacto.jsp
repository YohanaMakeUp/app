<%@ include file="../fragments/header.jspf" %>

<h1 class="logo">Contacto</h1>
<div id="container">
  <div class="content">
    <div id="fane1">
      <!-- Aqui va el formulario -->
	  <form Action="mailto:robertomore9@hotmail.com?Subject=Test_Post" METHOD="POST" enctype="text/plain">
	  <label>Nombre	</label><input id="Nombre" name ="Nombre del cliente" type="text" placeholder="Nombre" ><br>
	  <label>Apellido	</label><input id="Nombre" name ="Apellido del cliente" type="text" placeholder="Apellido"><br>
	  <label>Email  </label><input id="Nombre" name="Email del cliente" type="text" placeholder="Email"><br>
	  <label>Asunto</label><br>
		<textarea id="nuevoTextoDescriptivo" name="Asunto" style="resize:none;"></textarea><br>
		<input type="submit"  value="Enviar"> 
		<input type="button" value="Resetear Formulario" onClick="this.form.reset()">
	  </form>
    </div>
  </div>
  <div style="clear:both"></div>
</div>
