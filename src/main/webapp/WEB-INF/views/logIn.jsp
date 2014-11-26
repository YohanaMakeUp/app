<%@ include file="../fragments/header.jspf" %>

<h1 class="logo">Log In</h1>
<div id="container">
  <div class="content">
    <div id="fane1">
      <!-- Aqui va el formulario -->
	  <form action="logIn" id="formularioLogIn" method="POST">
	  <label>Usuario	</label><input id="Nombre" name="name" type="text"><br>
	  <label>Password  </label><input id="Nombre" name="password" type="password" ><br>
		<input type="submit" value="Sign In"> 
	  </form>
    </div>
  </div>
  <div style="clear:both"></div>
</div>
