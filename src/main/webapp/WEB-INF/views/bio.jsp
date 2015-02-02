<%@ include file="../fragments/header.jspf"%>

<h1 class="logo">Bio</h1>
<div id="container">
	
	<div id="bio" class="one-third"
		style="font-family: Georgia, 'Times New Roman', Times, serif; letter-spacing: 2px">
		
		<h5 id="tituloBio">${titulo.getTitulo()}</h5>
		<p id="descripcion">${texto.getTexto()} </p>
	</div>
	<div style="margin-left: -19px; margin-bottom: 15px;">

	<c:forEach items="${fotos}" var="f">
       <!-- Cambiamos la ruta a la nueva carpeta -->	
    		<img src="photo/?folder=bio&id=${f}" alt="" width="550" height="350" >
  	</c:forEach>		
	</div>
	<c:choose>
		<c:when test="${user.getRole() == 'Admin' and not empty user}">
		 <form action="bio" id="formularioEditarIndex" method="POST">
			<label>Cambiar
				Titulo
				</label>
			<input id="nuevoTitulo" name="nuevoTitulo" type="text" value="${titulo.getTitulo()}">
			<br>
			<label>Cambiar Descripcion</label>
			<br>
			<textArea id="nuevaDescripcion" name="nuevaDescripcion">${texto.getTexto()}</textArea>
			
			<input id="nuevoTituloBio" name="Confirmar"type="submit">
			
			</form>
		</c:when>
	</c:choose>
	<div style="clear: both"></div>

</div>
<!-- close container -->
</body>


