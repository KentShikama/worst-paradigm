<%--
  Created by IntelliJ IDEA.
  User: kent
  Date: 12/1/14
  Time: 1:15 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Recognition Test</title>
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>
</head>

<body
<div class="vertical-center">
    <div class="container">
        <div style="max-width: 600px; margin: 0 auto;">
            <h3 style="text-align: center">
                Do you recall seeing a ${typeOfImage} of the word ${word}?
            </h3>

            <div class="spacing50"></div>
            <g:form class="form-horizontal form-actions">
                <g:actionSubmit class="btn btn-default" name="yes" action="yes" value="Yes"/>
                <span class="padding10"></span>
                <g:actionSubmit class="btn btn-default" name="no" action="no" value="No"/>
            </g:form>
        </div>
    </div>
</div>
</body>
</html>