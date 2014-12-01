<%--
  Created by IntelliJ IDEA.
  User: kent
  Date: 11/30/14
  Time: 4:10 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Study</title>
    <asset:javascript src="application.js"/>
    <asset:javascript src="ticker.js"/>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#fade').list_ticker({
                speed: 1000,
                effect: 'fade'
            });
        })
    </script>
</head>

<body>
<ul id="fade">
    <g:layoutBody/>
</ul>
<a style="display:none" id="linkToDistractionTask" href="${createLink(controller: 'distraction', action: 'index')}"/>
</body>
</html>