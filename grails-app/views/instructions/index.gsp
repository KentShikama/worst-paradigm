<%--
  Created by IntelliJ IDEA.
  User: kent
  Date: 11/29/14
  Time: 4:22 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Instructions</title>
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>
</head>

<body>
<div class="vertical-center">
    <div style="max-width: 500px; margin: 0 auto;">
        <h1>Instructions</h1>

        <p>You will now be shown a series of fifteen images where each will be flashed for about a second. Try to remember as many as you can. Afterwards, you will be asked to recall as many images from the series as you can, in no particular order.</p>

        <p>You may continue whenever you are ready.</p>

        <div class="spacing50"></div>

        <div style="text-align:center;">
            <g:link action="jumpToStudy">
                <button class="btn btn-default">Start Experiment</button>
            </g:link>
        </div>
    </div>
</div>
</body>
</html>