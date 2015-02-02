<%@ include file="../fragments/header.jspf"%>

<h1 class="logo">Registro de Usuario</h1>
<div id="container">
	<div class="content">
		<div id="fane1">
			<!-- Aqui va el formulario -->
			<form action="registro" id="formularioRegistro" method="POST">
				<input type="hidden" id="source" name="source"
					value="${requestScope['javax.servlet.forward.servlet_path']}" /> 
				<label>Nombre</label><br>
				<input id="nombre" name="nombre" type="text" required><br> 
				<label>Apellidos</label><br>
				<input id="apellidos" name="apellidos" type="text" required><br> 
				<label>Email</label><br>
				<input id="email" name="email" type="email" required><br> 
				<label>Nombre de usuario</label><br>
				<input id="nombreUsuario" name="nombreUsuario" type="text" required><br>
				<label>Password </label><br><input id="password" name="password1"
					type="password" required><br> <label>Repetir password </label><br><input
					id="password" name="password2" type="password" required><br> <input
					type="submit" value="Enviar formulario"> <input
					type="button" value="Resetear Formulario"
					onClick="this.form.reset()"> <label></label>
				<!--  	<c:if test="${not empty errores}">
					Eres un listillo, esta es la lista de errores:
					<ul><c:forEach items="${errores}" var="e">
						<li>${e}</li>
					</c:forEach></ul>
				</c:if>
				-->
				<label style="color: #FF0000"> ${error} </label>

			</form>
		</div>
	</div>
	<div style="clear: both"></div>
</div>
