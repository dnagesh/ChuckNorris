<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>ChuckNorris jokes changing character name</title>	
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
</head>
 
<body>

<script type="text/javascript">
  $(document).ready(function() {
		  $( "#dialog-1" ).dialog({
	          autoOpen: false, 
	          modal: true,
	          buttons: {
	             OK: function() {$(this).dialog("close");}
	          },
	       });
	 	 $('.searchButton').click(function() { 
	    	 $.ajax({
	 		type: 'GET',
	 		url:'change.action?name='+ $("#name").val(),
        	cache: false,
	 		success: function(result) {
	 			 $("#dialog-1").html(result).dialog();
                 $("#dialog-1").dialog('open');
	 		},
			error : function(x,e) {
				alert("oops! something wrong.");
			}
	 	  });
	 	});
	 	}); 
  </script>
	 <span><p>Please enter first name and second name</p></span>
	   <div id = "dialog-1" title = "Random Joke with Changed Character"></div>
  	<s:form  theme="xhtml">
		<input type="textbox" id="name" name="name"  label="Enter your Name"/>&nbsp;
		<input type="button" value="Search" class="searchButton"/>
		<br>
		<br>
		<s:url value="index.action" var="homeUrl" />
		Return to&nbsp;<s:a href="%{homeUrl}">home</s:a>
 </s:form>

</body>
</html>