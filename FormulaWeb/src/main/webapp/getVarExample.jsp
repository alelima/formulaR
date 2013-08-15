<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.nitrox.formular.*" %>
<%@page import="java.util.HashSet" %>

<%
Formula formula = new Formula();
String expression = request.getParameter("expression");
HashSet<Variable> variables = new HashSet<Variable>();
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <form method="get" action="getVarExample.jsp">
        <input type="text" name="expression" max="70">
        <br/>
        <input type="submit" name="submit" value="Submit">        
    </form>

<%
if(expression != null && !expression.equals("")) {
    String mensage = "Invalid Expression";
    boolean resultado = formula.isValid(expression);
    if(resultado) {
%>
<h3> Variables of expression <%=expression%>: </h3>
<ul>
<%
        variables = formula.getExpressionVariables(expression);
        for (Variable variable : variables) {
%>
        <li><span> <%=variable.getName()%> </span>   
            <br>
<%            
        }
%>
</ul>    
<%
    } else {
%>   
 
<h1> <%=mensage%> </h1>

<%
    }
} else {     
%>  
<h1> Insert a expression </h1>

<%
}
%>
</html>