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
    <form method="get" action="isValidExample.jsp">
        <input type="text" name="expression" max="70">
        <br/>
        <input type="submit" name="submit" value="Submit">        
    </form>

<%
if(expression != null && !expression.equals("")) {
    String mensage = "Invalid Expression";
    boolean resultado = formula.isValid(expression);
    if(resultado) {
        mensage = "The Expression is Valid";
    }
%>   
 
<h1> <%=mensage%> </h1>
<h2> <%=expression%> </h2>
<h1> <%=resultado%> </h1>

<%
} else {     
%>  
<h1> Insert a expression </h1>

<%
}
%>
</html>
