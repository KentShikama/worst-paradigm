<%--
  Created by IntelliJ IDEA.
  User: kent
  Date: 11/29/14
  Time: 3:45 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Memory Experiment</title>
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>
</head>

<body>
<div class="vertical-center">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-7 vertical-align">
                <p>You will be participating in a study that is being run as a part of a project for the Introduction to Cognitive Science Course at Pomona College.  This study is designed to _____.  The procedures will involve _____.  The whole process will take _____ minutes to complete.</p>

                <p>Although this experiment involves no foreseeable risks, if at any time you want to stop the experiment you are free to refuse further participation without penalty.  You may ask questions at any time.</p>

                <p>All results will remain strictly confidential.  Your name will not be linked to any data collected during this experiment.</p>

                <p>If you have any further questions about this research either now or at a later time, please contact [your name] at [your email].  You may also contact the instructor for the course: Laura Johnson at laura.johnson@pomona.edu.</p>

                <p>In order to participate in this experiment you must give your informed consent.  By clicking continue you indicate that you understand your role in this research and agree to participate.</p>
            </div><!--
        --><div class="col-xs-12 col-sm-10 col-md-5 vertical-align">
            <g:form class="form-horizontal form-actions" controller="start" action="jumpToInstructions">
                <div class="form-group">
                    <label class="control-label col-sm-3" for="age">Age:</label>
                    <g:select id="age" class="col-sm-9 selectpicker" data-live-search="true" name="age"
                              from="${13..99}" value="${age}"/>
                </div>

                <div class="spacing"></div>

                <div class="form-group">
                    <label class="control-label col-sm-3" for="gender">Gender:</label>
                    <g:select id="gender" class="col-sm-9 selectpicker" data-live-search="true" name="gender"
                              from="['Male', 'Female', 'N/A']" value="${gender}"/>
                </div>

                <div class="spacing"></div>

                <g:submitButton class="btn btn-default" name="submit" value="Continue"/>
            </g:form>
        </div>
        </div>
    </div>
</div>
</body>
</html>