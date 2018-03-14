<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>ChuckNorris Jokes UI</title>	
      <link href = "https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel = "stylesheet">
      <script src = "https://code.jquery.com/jquery-3.3.1.js"></script>
      <script src = "https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
       <!-- CSS -->
      <style>
         .ui-widget-header,.ui-state-default, ui-button {
            background:#b9cd6d;
            border: 1px solid #b9cd6d;
            color: #FFFFFF;
            font-weight: bold;
         }
      </style>
      
      <script type="text/javascript">
  $(document).ready(function() {
	   $( "#dialog" ).dialog({
          autoOpen: false, 
          modal: true,
          buttons: {
             OK: function() {$(this).dialog("close");}
          },
       });
    	 $('.buttonrandom').click(function() { 
	    	 $.ajax({
	 		type: 'GET',
	 		url: 'popUp',
	 		cache: false,
	 		success: function(result) {
	 			 $("#dialog").html(result).dialog();
                 $("#dialog").dialog('open');
	 		}
	 	  });
	 	});
	 	}); 
   
   function setActionAndSubmit(form, newAction) {
	    form.action = newAction; 
	    form.submit();
	}

  </script>
  </head>
  <body>
  
  
    <h1>Chuck Norris Jokes Home Page</h1>
    <form>
    <div id = "dialog" title = "Chuck Norris Joke"></div>
    <input type="button" value="Random Joke" class="buttonrandom"/>
    <input type="button" value="Text input" class="buttonText" onclick="setActionAndSubmit(this.form,'search')"/>
    <input type="button" value="Never-ending Jokes" class="buttonText" onclick="setActionAndSubmit(this.form,'view')"/>
    <br>
    </form>
  </body>
</html>