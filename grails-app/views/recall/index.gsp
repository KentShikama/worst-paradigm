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
<div class="vertical-center">
    <div class="container">
        <div style="max-width: 500px; margin: 0 auto;">
            <h1>Free Recall Test</h1>

            <p>Please provide a one-to-two-word description of each image you can recall in the textfield below (e.g. 'umbrella,' or 'tennis player'). You do not have to recall the images in order. If you make a mistake you can delete a word/description by clicking the 'x' button next to each word. When you are finished, please click the 'I cannot recall any more words' button below.</p>
        </div>

        <div class="spacing20"></div>

        <g:form class="form-inline form-actions">
            <div class="form-group padding10" style="margin-top: 2px;">
                <g:if test="${recalledWords == null || recalledWords.isEmpty()}">
                    <g:textField name="word" id="textField" value="Type word and hit enter" onfocus="if (this.value == 'Type word and hit enter') {this.value=''}"/>
                </g:if>
                <g:else>
                    <g:textField name="word" id="textField"/>
                </g:else>
            </div>

            <div class="form-group padding10">
                <g:actionSubmit class="btn btn-default" name="submit" action="addWord" value="Submit"/>
            </div>
        </g:form>
        <div class="spacing20"></div>

        <div align="center">
            <g:each var="word" in="${recalledWords}">
                <h4>${word} <a href='${createLink(action: 'deleteWord')}?word=${word}'><span
                        class="glyphicon glyphicon-remove-circle" style="font-size: 16px;"></span></a>
                </h4>
            </g:each>
        </div>
        <div class="spacing20"></div>
        <g:form class="form-horizontal form-actions">
            <g:actionSubmit class="btn btn-default" name="done" action="submit" value="I cannot recall any more words"/>
        </g:form>
    </div>
</div>
</body>
</html>