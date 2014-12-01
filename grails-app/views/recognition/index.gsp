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
    <g:each var="word" in="${wordList}">
        <p>${word}</p>
    </g:each>
</div>
</body>
</html>