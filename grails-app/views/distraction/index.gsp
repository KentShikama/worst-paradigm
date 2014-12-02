<%--
  Created by IntelliJ IDEA.
  User: kent
  Date: 11/30/14
  Time: 7:49 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Distraction</title>
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>
</head>

<body>
<div class="vertical-center">
    <div class="container">
    <table align="center">
        <tr>
            <td><h1>&nbsp</h1></td>
            <td><h1>${firstNumber}</h1></td>
        </tr>
        <tr>
            <td><h1>+</h1></td>
            <td><h1>${secondNumber}</h1></td>
        </tr>
    </table>
    <g:form class="form-horizontal form-actions" action="index">
        <g:textField name="answer"/>
        <g:submitButton class="btn btn-default" name="submit" value="Submit"/>
    </g:form>
    <g:if test="${errorMessage}">
        <p>${errorMessage}</p>
    </g:if>
    </div>
</div>
</body>
</html>