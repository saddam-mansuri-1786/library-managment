<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String message = request.getParameter("message");
if(message!=null){
	out.print("<p>"+message+"</p>");
}
%>