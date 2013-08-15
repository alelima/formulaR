<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.nitrox.formular.*" %>
<%@page import="java.math.BigDecimal" %>

<%
String expression = "(( b1 + b2 ) / 2) * height";
String b1Value = request.getParameter("b1");
String b2Value = request.getParameter("b2");
String heightValue = request.getParameter("height");
BigDecimal result = new BigDecimal("0.00");

if(b1Value != null && !b1Value.equals("") &&
    b2Value != null && !b2Value.equals("") &&
    heightValue != null && !heightValue.equals("")) {

    Variable b1 = new Variable();
    Variable b2 = new Variable();
    Variable height = new Variable();

    b1.setName("b1");
    b1.setValue(new BigDecimal(b1Value));

    b2.setName("b2");
    b2.setValue(new BigDecimal(b2Value));

    height.setName("height");
    height.setValue(new BigDecimal(heightValue));    

    Formula formula = new Formula();
    formula.setExpression(expression);
    formula.putVar(b1, b2, height);
    
    result = formula.eval();
}


%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <h2> Expression: <%=expression%> </h2>
    <form method="get" action="evalExample.jsp">
        <span>b1:</span> <input type="text" name="b1" max="10">
        <br/>
        <span>b2:</span> <input type="text" name="b2" max="10">
        <br/>
        <span>height:</span> <input type="text" name="height" max="10">
        <br/>
        <input type="submit" name="submit" value="Submit">        
    </form>  
 
<h1> Result: <%=result%> </h1>



</html>
