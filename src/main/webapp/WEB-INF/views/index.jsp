<%@ include file="../fragments/header.jspf" %>

<script>
jQuery.noConflict()(function ($) {
    $('#ei-slider').eislideshow({
        animation: 'center',
        autoplay: true,
        slideshow_interval: 3000,
        titlesFactor: 0
    });
});
</script>

<div class="wrapper">
  <div id="ei-slider" class="ei-slider">
    <ul class="ei-slider-large">
      <li> <img src="resources/img/large/1.jpg" alt="">
       
      </li>
      <li> <img src="resources/img/large/2.jpg" alt="">
        
      </li>
      <li> <img src="resources/img/large/3.jpg" alt="">

      </li>
      <li> <img src="resources/img/large/4.jpg" alt="">
       
      </li>
      <li> <img src="resources/img/large/5.jpg" alt="">
        
      </li>
      <li> <img src="resources/img/large/6.jpg" alt="">
        
      </li>
      <li> <img src="resources/img/large/7.jpg" alt="">
       
      </li>
    </ul>
    <!-- ei-slider-large -->
    <ul class="ei-slider-thumbs">
      <li class="ei-slider-element">Current</li>
      <li><a href="#">Slide 1</a><img src="resources/img/thumbs/1.jpg" alt=""></li>
      <li><a href="#">Slide 2</a><img src="resources/img/thumbs/2.jpg" alt=""></li>
      <li><a href="#">Slide 3</a><img src="resources/img/thumbs/3.jpg" alt=""></li>
      <li><a href="#">Slide 4</a><img src="resources/img/thumbs/4.jpg" alt=""></li>
      <li><a href="#">Slide 5</a><img src="resources/img/thumbs/5.jpg" alt=""></li>
      <li><a href="#">Slide 6</a><img src="resources/img/thumbs/6.jpg" alt=""></li>
      <li><a href="#">Slide 7</a><img src="resources/img/thumbs/7.jpg" alt=""></li>
    </ul>
    <!-- ei-slider-thumbs -->
  </div>
  <!-- ei-slider -->
</div>
<!-- wrapper -->
<div id="container" style="box-shadow: none; border: none">
  <div class="none">
    <h5><b>Yohana Moreno Rojas, profesional dedicada al mundo del maquillaje y la peluqueria.</b></h5>
    <c:choose>
    <c:when test="${user.getRole() == 'Admin' and not empty user}">
	 <button onclick='getElementById("titulo").innerHTML=getElementById("nuevoTitulo").value'>Cambiar Titulo</button>
  <input id="nuevoTitulo" name="nuevoTitulo" type = "text"><br>
    </c:when>
  </c:choose>
	<h5>Editorial, Moda/Belleza, Producción Gráfica, Rodaje Publicitario, Celebrities, Pasarela, Eventos, Asesoramiento, Novias, Automaquillaje.</h5>
  </div>
  <c:choose>
   <c:when test="${user.getRole() eq 'Admin' and not empty user}">
   <button onclick='getElementById("titulo").innerHTML=getElementById("nuevoTitulo").value'>Cambiar Titulo</button>
  <input id="nuevoTitulo" name="nuevoTitulo" type = "text"><br>
  </c:when>
   </c:choose>
</div>
