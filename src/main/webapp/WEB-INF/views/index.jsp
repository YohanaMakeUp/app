<%@ include file="../fragments/header.jspf"%>

<script>
	jQuery.noConflict()(function($) {
		$('#ei-slider').eislideshow({
			animation : 'center',
			autoplay : true,
			slideshow_interval : 3000,
			titlesFactor : 0
		});
	});
</script>

<div class="wrapper">
	<div id="ei-slider" class="ei-slider">
		
		<ul class="ei-slider-large">
		<c:forEach items="${fotos}" var="f">
			<li><img src="photo/?folder=index&id=${f}" alt=""></li>
			
			</c:forEach>
		</ul>
			
		<!-- ei-slider-large -->
		<ul class="ei-slider-thumbs">
			<li class="ei-slider-element">Current</li>
			<c:forEach items="${fotosT}" var="f">
			<li><a href="#">Slide #</a><img src="photo/?folder=thumbs&id=${f}" alt=""></li>
				</c:forEach>
		</ul>
		<!-- ei-slider-thumbs -->
	</div>
	<!-- ei-slider -->
</div>
<!-- wrapper -->
<div id="container" style="box-shadow: none; border: none">
	<div class="none">
		<h5 id="tituloIndex">
			${titulo.getTitulo()} 
			<!-- Yohana Moreno Rojas, profesional dedicada al mundo del
				maquillaje y la peluqueria. -->
		</h5>
		<c:choose>
			<c:when test="${user.getRole() == 'Admin' and not empty user}">
				 <form action="index" id="formularioEditarIndex" method="POST">
				<!-- <button 
					onclick='getElementById("tituloIndex").innerHTML=getElementById("nuevoTituloIndex").value'>Cambiar
					Titulo</button>-->
					<label>Cambiar Titulo</label><input name ="nuevoTituloIndex" type="text">
					<input id="nuevoTituloIndex" name="Confirmar"type="submit">
				</form>
				<br>
			</c:when>
		</c:choose>
		
			
		<h5 id="tituloIndexDos">
		${texto.getTexto()}
		<!--Editorial, Moda/Belleza, Producción
			Gráfica, Rodaje Publicitario, Celebrities, Pasarela, Eventos,
			Asesoramiento, Novias, Automaquillaje.--></h5>
	</div>
	<c:choose>
		<c:when test="${user.getRole() eq 'Admin' and not empty user}">
			
		<form action="index" id="formularioEditarIndexDos" method="POST">
				<label>Cambiar Texto</label><input name ="nuevoTituloIndexDos" type="text">
			<input id="nuevoTituloIndexDos" name="Confirmar"type="submit">
				</form>
			<br>
		</c:when>
	</c:choose>
</div>
