<%@ include file="../fragments/header.jspf"%>

<h1 class="logo">Registro de Usuario</h1>
<div id="container">
	<div class="content">
		<div id="fane1">
			<!-- Aqui va el formulario -->
			<form action="registro" id="formularioRegistro" method="POST">
				<input type="hidden" id="source" name="source"
					value="${requestScope['javax.servlet.forward.servlet_path']}" /> 
				<label>Nombre</label>
				<input id="nombre" name="nombre" type="text"><br> 
				<label>Email</label>
				<input id="email" name="email" type="text"><br> 
				<label>Usuario</label>
				<input id="nombreUsuario" name="nombreUsuario" type="text"><br>
				<label>Password </label><input id="password" name="password1"
					type="password"><br> <label>Repetir password </label><input
					id="password" name="password2" type="password"><br> <input
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
				<label> ${error} </label>

			</form>
		</div>
	</div>
	<div style="clear: both"></div>
</div>
