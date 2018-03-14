<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <title>ChuckNorris Muliple Jokes</title>	
    <script type="text/javascript" src="include/js/ap.js"></script>
	<script src = "https://code.jquery.com/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$contentLoadTriggered = false;
		$("#mainDiv").scroll(
			 function() {
				if ($("#mainDiv").scrollTop() >= ($("#wrapperDiv").height() - $("#mainDiv").height())
				&& $contentLoadTriggered == false) {
				   $contentLoadTriggered = true;
				   $.ajax({url : 'scroll',success : function(data) {
				   		$("#wrapperDiv").append(data);
				   		$contentLoadTriggered = false;
				   },
					error : function(x,e) {
						alert("The call to the server side failed. Error: "+ e);
					}
				});
			}
		});
	SS});
</script>

<style type="text/css">
body {
	font-family: Arial;
	font-size: .93em;
}

#mainDiv {
	background-color: #FAFAFA;
	border: 2px solid #888;
	height: 200px;
	overflow: scroll;
	padding: 4px;
	width: 700px;
}

#mainDiv p {
	border: 1px solid #EEE;
	background-color: #F0F0F0;
	padding: 3px;
}

#mainDiv p span {
	color: #00F;
	display: block;
	font: bold 21px Arial;
	float: left;
	margin-right: 10px;
}
</style>

</head>
<body>
	<form id="form1">
		<div>
			<h1>Never-ending Jokes</h1>
			<p></p>
			<p
				style="margin: 20px 0; background-color: #EFEFEF; border: 1px solid #EEE; padding: 3px;">
				This page loads new jokes from the server while scrolling.</p>
		</div>
		<div id="mainDiv">
			<div id="wrapperDiv">
			 <s:iterator value="jokes">
   				<p> <s:property/></p>
 			</s:iterator>
			</div>
		</div>
		<br>
		<br>
		<s:url value="index.action" var="homeUrl" />
		Return to&nbsp;<s:a href="%{homeUrl}">home</s:a>
	</form>
</body>
</html>