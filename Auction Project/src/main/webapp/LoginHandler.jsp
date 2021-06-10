<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="storage.DBData" %>
<jsp:useBean id="obj" class="bean1.SignupBean" scope="session"/>
<jsp:setProperty property="*" name="obj" />

<%
	String status = DBData.checkLogin(obj);
	if(status.equals("true")){
		session.setAttribute("email",obj.getEmail());
		response.sendRedirect("home.jsp");
	}
	if(status.equals("false")){
		response.sendRedirect("index.jsp?status=false");
	}
	if(status.equals("error")){
		response.sendRedirect("index.jsp?status=error");
	}
%>