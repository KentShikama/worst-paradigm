<%--
  Created by IntelliJ IDEA.
  User: kent
  Date: 12/1/14
  Time: 1:53 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Debriefing</title>
</head>

<body>
<h1>Debriefing</h1>

<p>Critical lure was recalled!</p>

<table>
    <tr>
        <th>ID</th>
        <th>Age</th>
        <th>Gender</th>
        <th>Study Type</th>
        <th>Critical Lure Recalled</th>
    </tr>
    <g:each var="person" in="${people}">
        <tr>
            <td>${person.id}</td>
            <td>${person.age}</td>
            <td>${person.gender}</td>
            <td>${person.studyType}</td>
            <td>${person.didRecallCriticalLureInFreeRecall}</td>
        </tr>
    </g:each>
</table>

</body>
</html>