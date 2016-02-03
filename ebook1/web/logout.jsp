<%-- 
    Document   : logout
    Created on : Mar 24, 2010, 2:35:04 PM
    Author     : sarat
--%>

<%-- 
    Document   : logout
    Created on : Mar 18, 2010, 11:23:45 PM
    Author     : venki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*, java.io.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>




<% out.println("<html><body background=\"fondl.JPG\">");
session.invalidate();%>
<center>
<h4><br> Thank You for using our services.<br><br><br> You were being Logged out </h4> <br>
<br>
<a href = "login.html"><h3> click here to login </h3></a><br>
</center>
<!--<a href="left.HTML" target="f2">click to see books as other user</a>-->


    </body>
</html>
