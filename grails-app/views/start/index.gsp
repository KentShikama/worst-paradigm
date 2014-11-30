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
<h1>Site Title</h1>

<div class="container">
    <div class="row">
        <div class="col-md-6">
            <h2>Experiment/Consent</h2>

            <p>You will be participating in a study that is being run as a part of a project for the Introduction to Cognitive Science Course at Pomona College.  This study is designed to _____.  The procedures will involve _____.  The whole process will take _____ minutes to complete.</p>

            <p>Although this experiment involves no foreseeable risks, if at any time you want to stop the experiment you are free to refuse further participation without penalty.  You may ask questions at any time.</p>

            <p>All results will remain strictly confidential.  Your name will not be linked to any data collected during this experiment.</p>

            <p>If you have any further questions about this research either now or at a later time, please contact [your name] at [your email].  You may also contact the instructor for the course: Laura Johnson at laura.johnson@pomona.edu.</p>

            <p>In order to participate in this experiment you must give your informed consent.  By signing this form you indicate that you understand your role in this research and agree to participate.</p>
        </div>

        <div class="col-md-6">
            <g:form controller="start" action="start">
                    <label class="control-label col-sm-2" for="age">Age:</label>
                    <div class="col-sm-10">
                        <g:select id="age" class="selectpicker" data-live-search="true" name="age"
                                  from="${18..65}" value="${age}"/>
                    </div>

                    <label class="control-label col-sm-2" for="gender">Gender:</label>
                    <div class="col-sm-10">
                        <g:select id="gender" class="selectpicker" data-live-search="true" name="gender"
                                  from="['Male', 'Female']" value="${gender}"/>
                    </div>

                <div class="checkbox">
                    <label>
                        <g:checkBox name="terms"/>I agree with all the terms
                    </label>
                </div>
                <g:submitButton class="btn btn-default" name="submit" value="Continue"/>
            </g:form>
        </div>
    </div>
</div>
</body>
</html>