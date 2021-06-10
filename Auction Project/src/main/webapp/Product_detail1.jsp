<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@include file="BootStrapeCDN.jsp"%>
 <%@ page import="storage.ProductData" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:useBean id="obj" class=bean1.ProductBean" />
<jsp:setProperty name="obj" property="*" />
<%
	ProductData.setProductDetails1(obj);
%>
</head>
<body>

<div class="container">
	<div class="row">
		
	</div>
	<div class="row">
		<div class="col-md-3">
		
		</div>		
		<div class="col-md-6">
		<fieldset>
		<legend>Upload Product Image</legend>
			<form action="index.jsp" method="post" enctype="multipart/form-data">
				<input type="file" name="photo" class="form-control"/>
				<input type="submit" value="Upload Image" class="btn btn-block btn-warning"/>
			</form>
			</fieldset>
		</div>
		<div class="col-md-3">
		
		</div>
	</div>
</div>
</body>
</html>