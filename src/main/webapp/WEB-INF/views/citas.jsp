<%@ include file="../fragments/header.jspf" %>

<script src="https:\\code.jquery.com/jquery-1.10.2.js"></script> 
<script src="https:\\code.jquery.com/ui/1.11.2/jquery-ui.js"></script> 

 <script>
  $(function() {
    $( "#from" ).datepicker({
      defaultDate: "+1w",
      changeMonth: true,
      numberOfMonths: 3,
      onClose: function( selectedDate ) {
        $( "#to" ).datepicker( "option", "minDate", selectedDate );
      }
    });
    $( "#to" ).datepicker({
      defaultDate: "+1w",
      changeMonth: true,
      numberOfMonths: 3,
      onClose: function( selectedDate ) {
        $( "#from" ).datepicker( "option", "maxDate", selectedDate );
      }
    });
  });
  </script>

<h1 class="logo">Citas</h1>
<div id="container">
  <div class="content">
    <div id="fane1">
      <!-- Aqui va el formulario -->
	  <form>
	  <label for="from">From</label>
<input type="text" id="from" name="from">
<label for="to">to</label>
<input type="text" id="to" name="to">
	  </form>
    </div>
  </div>
  <div style="clear:both"></div>
</div>
