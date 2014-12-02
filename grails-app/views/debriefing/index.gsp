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

<div class="vertical-center">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-7 vertical-align">
                <h2>Explanation</h2>
                <g:if test="${you.studyType == 'linedrawings'}">
                    <p>This experiment was designed to test the frequency of false memories in relationship to the detail of pictures given to participants. Your group was shown line drawings, while another group was shown photographs.</p>
                </g:if>
                <g:else>
                    <p>This experiment was designed to test the frequency of false memories in relationship to the detail of pictures given to participants. Your group was shown photographs, while another group was shown line drawings.</p>
                </g:else>
                <p>Our experiment uses the Desse-Rediger-McDermott (DRM) paradigm, which induces false memory of a “lure” word, using a list of related words. In this case, our lure was “foot.”</p>

                <p>For your reference, you can see various statistics on the right about how you and others have performed on this test thus far. If you are interested in our findings at a later time, or (again) you have any concerns about what happened during the experiment, you may contact Jordan Wong at jordan.wong@pomona.edu.</p>
            </div><!--
        --><div class="col-xs-12 col-sm-10 col-md-5 vertical-align">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Study Type</th>
                    <th>Number of True Words</th>
                    <th>Critical Lure Recalled</th>
                </tr>
                <g:each var="person" in="${people}">
                    <tr>
                        <td>${person.id}</td>
                        <td>${person.age}</td>
                        <td>${person.gender}</td>
                        <td>${person.studyType}</td>
                        <td>${person.numberOfTrueWordsRecalled}</td>
                        <td>${person.didRecallCriticalLureInFreeRecall}</td>
                    </tr>
                </g:each>
            </table>
        </div>
        </div>
    </div>
</div>
</body>
</html>