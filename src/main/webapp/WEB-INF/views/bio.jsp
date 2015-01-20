<%@ include file="../fragments/header.jspf"%>



<h1 class="logo">Bio</h1>
<div id="container">
	<div id="bio" class="one-third"
		style="font-family: Georgia, 'Times New Roman', Times, serif; letter-spacing: 2px">
		<h2 id="titulo">Titulos</h2>
		<p id="descripcion">Lorem Ipsum es simplemente el texto de relleno
			de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de
			relleno estándar de las industrias desde el año 1500, cuando un
			impresor (N. del T. persona que se dedica a la imprenta) desconocido
			usó una galería de textos y los mezcló de tal manera que logró
			hacer un libro de textos especimen. No sólo sobrevivió 500 años,
			sino que tambien ingresó como texto de relleno en documentos
			electrónicos, quedando esencialmente igual al original. Fue
			popularizado en los 60s con la creación de las hojas "Letraset", las
			cuales contenian pasajes de Lorem Ipsum, y más recientemente con
			software de autoedición, como por ejemplo Aldus PageMaker, el cual
			incluye versiones de Lorem Ipsum.</p>
	</div>
	<div style="margin-left: -19px; margin-bottom: 15px;">
		<img title="" src="resources/img/slideshow/slide_2.jpg" alt=""
			width="600" height="450">
	</div>
	<c:choose>
		<c:when test="${user.getRole() == 'Admin' and not empty user}">
			<button
				onclick='getElementById("titulo").innerHTML=getElementById("nuevoTitulo").value'>Cambiar
				Titulo</button>
			<input id="nuevoTitulo" name="nuevoTitulo" type="text">
			<br>
			<button
				onclick='getElementById("descripcion").innerHTML = getElementById("nuevaDescripcion").value'>Cambiar
				Descripcion</button>
			<br>
			<textArea id="nuevaDescripcion" name="nuevaDescripcion" type="text"></textArea>
			<br>
		</c:when>
	</c:choose>
	<div style="clear: both"></div>
</div>
<!-- close container -->

</body>


