<%@ include file="../fragments/header.jspf" %>

<h1 class="logo">Log In</h1>
<div id="container">
  <div class="content">
    <div id="fane1">
      <!-- Aqui va el formulario -->
	  <form action="logIn" id="formularioLogIn" method="POST">
	  <label>Usuario </label><br><input id="Nombre" name="name" type="text" required><br>
	  <label>Password </label><br><input id="password" name="password" type="password" required><br>
		<input type="submit" value="Log In"> 
	  </form>
	  <label style="color: #FF0000"> ${error} </label>
    </div>
  </div>
  <div style="clear:both"></div>
</div>
