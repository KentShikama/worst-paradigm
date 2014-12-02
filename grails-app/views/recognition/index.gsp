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
</head>

<body>
<h1>Recognition Test</h1>

<div>
    <h2>Do you recall seeing the word ${word}</h2>
    <g:form class="form-horizontal form-actions">
        <g:actionSubmit class="btn btn-default" name="yes" action="yes" value="Yes"/>
        <g:actionSubmit class="btn btn-default" name="no" action="no" value="No"/>
    </g:form>
</div>
</body>
</html>