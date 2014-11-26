<%@ include file="../fragments/header.jspf" %>



<h1 class="logo">Bio</h1>
<div id="container">
  <div id = "bio" class="one-third" style="font-family:Georgia, 'Times New Roman', Times, serif; letter-spacing: 2px">
    <h2 id ="h2">Titulos</h2>
    <p id ="p1">Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto.
	Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. 
	No sólo sobrevivió 500 años, sino que tambien ingresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. 
	Fue popularizado en los 60s con la creación de las hojas "Letraset", las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lorem Ipsum. </p>
  </div>
  <div style="margin-left: -19px; margin-bottom: 15px;"> <img title="" src="resources/img/slideshow/slide_2.jpg" alt="" width="600" height="450"> </div>
  <button onclick='getElementById("h2").innerHTML=getElementById("p4").value'>Cambiar Titulo</button>
  <input id="p4" name="p4" type = "text"><br>  
  <button onclick='getElementById("p1").innerHTML = getElementById("p3").value'>Cambiar Descripcion</button>
  <input id="p3" name="p3" type = "text"><br> 
  <div style="clear:both"></div>
</div>
<!-- close container -->

</body>


