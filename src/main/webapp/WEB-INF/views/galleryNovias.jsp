<%@ include file="../fragments/header.jspf" %>

<h1 class="logo">Novias</h1>
<div id="container">
  	<c:forEach items="${fotos}" var="f">
	<div class="one-fifth">
    	<p> 
       <!-- Cambiamos la ruta a la nueva carpeta -->
    		<a title="" href="photo/?folder=novias&id=${f}" 
    			class="portfolio-item-preview" data-rel="prettyPhoto">
    		<img src="photo/?folder=novias&id=${f}" alt="" width="158" height="100" 
    			class="portfolio-img pretty-box"></a> </p>
  	</div>
  </c:forEach>
</div>
