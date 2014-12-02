<%--
  Created by IntelliJ IDEA.
  User: kent
  Date: 12/1/14
  Time: 12:13 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Free Recall Test</title>
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>
</head>

<body>
<h1>Free Recall Test</h1>

<p>Instructions for free recall. It should be pretty straightforward; however, a couple words might be needed</p>
<g:form class="form-horizontal form-actions">
    <g:textField name="word"/>
    <g:actionSubmit class="btn btn-default" name="submit" action="addWord" value="Submit"/>
</g:form>
<div>
    <g:each var="word" in="${recalledWords}">
        <p><a href='${createLink(action: 'deleteWord')}?word=${word}'>${word}</a></p>
    </g:each>
</div>
<g:form class="form-horizontal form-actions">
    <g:actionSubmit class="btn btn-default" name="done" action="submit" value="Done"/>
</g:form>
</body>
</html>