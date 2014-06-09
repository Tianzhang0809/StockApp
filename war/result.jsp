<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
<%  StringBuilder json= new StringBuilder();
	json.append("{\"company\":\"").append(request.getAttribute("company")).append("\"");
    json.append(", \"price\":\"").append(request.getAttribute("price")).append("\"");
    json.append(", \"peg\":\"").append(request.getAttribute("peg")).append("\"}");

%>
<%
	out.println(json.toString());
%>
</body>
</html>