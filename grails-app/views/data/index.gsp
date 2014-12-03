<%--
  Created by IntelliJ IDEA.
  User: kent
  Date: 12/2/14
  Time: 5:46 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Data</title>
</head>

<body>
<table>
    <tr>
        <th>ID</th>
        <th>Age</th>
        <th>Gender</th>
        <th>Study Type</th>
        <th>Number of True Words</th>
        <th>Critical Lure Recalled</th>
        <th>Critical Lure Recognized</th>
        <th>List of True Words Recalled</th>
        <th>List of False Words Recalled</th>
    </tr>
    <g:each var="person" in="${people}">
        <tr>
            <td>${person.id}</td>
            <td>${person.age}</td>
            <td>${person.gender}</td>
            <td>${person.studyType}</td>
            <td>${person.numberOfTrueWordsRecalled}</td>
            <td>${person.didRecallCriticalLureInFreeRecall}</td>
            <td>${person.didRecallCriticalLureInRecognition}</td>
            <td>
                <g:each var="word" in="${person.listOfTrueWordsRecalled}">
                    ${word},&nbsp
                </g:each>
            </td>
            <td>
                <g:each var="word" in="${person.listOfFalseWordsRecalled}">
                    ${word},&nbsp
                </g:each>
            </td>
        </tr>
    </g:each>
</table>
</body>
</html>