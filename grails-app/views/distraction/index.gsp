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
        <hr/>
        <div class="spacing20"></div>
        <div>
            <g:form class="form-inline form-actions" action="index">
                <div class="form-group padding10" style="margin-top: 2px;">
                    <g:textField name="answer"/>
                </div>

                <div class="form-group padding10">
                    <g:submitButton class="btn btn-default" name="submit" value="Submit"/>
                </div>
            </g:form>
            <g:if test="${errorMessage}">
                <p class="spacing20" align="center">${errorMessage}</p>
            </g:if>
        </div>
    </div>
</div>
</body>
</html>