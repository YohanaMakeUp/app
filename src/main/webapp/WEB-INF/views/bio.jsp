<%@ include file="../fragments/header.jspf"%>



<h1 class="logo">Bio</h1>
<div id="container">
	<div id="bio" class="one-third"
		style="font-family: Georgia, 'Times New Roman', Times, serif; letter-spacing: 2px">
		<!--<h2 id="titulo"> Titulos</h2> -->
		
		<h5 id="tituloBio">
			${titulo.getTitulo()} 
			</h5>
		
		<p id="descripcion">${texto.getTexto()} </p>
	</div>
	<div style="margin-left: -19px; margin-bottom: 15px;">
		<img title="" src="resources/img/slideshow/slide_2.jpg" alt=""
			width="600" height="450">
	</div>
	<c:choose>
		<c:when test="${user.getRole() == 'Admin' and not empty user}">
		 <form action="bio" id="formularioEditarIndex" method="POST">
			<label>Cambiar
				Titulo
				</label>
			<input id="nuevoTitulo" name="nuevoTitulo" type="text" value="${titulo.getTitulo()}">
			<br>
			<label>Cambiar
				Descripcion</label>
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


