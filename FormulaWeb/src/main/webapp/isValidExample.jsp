<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.nitrox.formular.Formula" %>

<%
Formula formula = new Formula();
String expression = request.getParameter("expression");
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

<%
if(expression != null && !expression.equals("")) {
    String mensage = "Invalid Expression";
    if(formula.isValid(expression)) {
        mensage = "The Expression is Valid";
    }
%>   
 


<%
}      
%>  

</html>
