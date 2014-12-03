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
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>
</head>

<body>
<div class="vertical-center">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-7 vertical-align">
                <g:if test="${you.studyType == 'lineDrawings'}">
                    <p>This experiment was designed to test the frequency of false memories in relation to the detail of pictures given to participants. Your group was shown line drawings, while another group was shown photographs.</p>
                </g:if>
                <g:else>
                    <p>This experiment was designed to test the frequency of false memories in relation to the detail of pictures given to participants. Your group was shown photographs, while another group was shown line drawings.</p>
                </g:else>
                <p>Our experiment uses the Desse-Rediger-McDermott (DRM) paradigm, which induces false memory of a “lure” word, using a list of related words. In this case, our lure was “foot,” which you <g:if
                        test="${you.didRecallCriticalLureInFreeRecall || you.didRecallCriticalLureInRecognition}">did</g:if><g:else>did not</g:else> falsely recall or recognize.
                <g:if test="${you.listOfFalseWordsRecalled != null && !you.listOfFalseWordsRecalled.isEmpty()}">
                    On a related note, you also falsely recalled
                    <g:each var="word" in="${you.listOfFalseWordsRecalled}" status="i">
                        <g:if test="${you.listOfFalseWordsRecalled.size() == 1}">'${word}'</g:if>
                        <g:elseif test="${i == you.listOfFalseWordsRecalled.size() - 1}">and '${word}'</g:elseif>
                        <g:else>'${word}',</g:else>
                    </g:each>.
                </g:if>
                </p>

                <p>Our original list of words includes shoe, hand, toe, kick, sandals, soccer, yard, walk, ankle, arm, boot, inch, sock, smell, and mouth. You successfully recalled ${you.numberOfTrueWordsRecalled} out of 15 items in the list. Note that we have given credit for either plural or singular versions of the word and <a href="${createLink(controller: 'debriefing', action: 'substitute')}">a list of possible substitutes.</a></p>

                <p>On the graph adjacent you can see the current results of our experiment. There have been ${numberOfParticipants} participants so far. We are looking to see if there is a statistically significant difference in the number of people who either recalled or recognized the lure word between the line drawing and the photograph group. If you are interested in our findings at a later time, or (again) you have any concerns about what happened during the experiment, you may contact Jordan Wong at jordan.wong@pomona.edu. If you have any issues with the website itself, please contact Kent Shikama at worstparadigm@gmail.com</p>
            </div><!--
        --><div class="col-xs-12 col-sm-12 col-md-5 vertical-align">
            <div style="max-width: 400px; margin: 0 auto;">
                <canvas id="cvs" width="400" height="450">[No canvas support]</canvas>
            </div>

            <div style="display:none" id="lineDrawingNumber">${lineDrawingNumber}</div>

            <div style="display:none" id="photographNumber">${photographNumber}</div>
        </div>
        </div>
    </div>
    <script>
        $(document).ready(function () {
            var lineDrawingNumber = parseInt(document.getElementById("lineDrawingNumber").innerHTML);
            var photographNumber = parseInt(document.getElementById("photographNumber").innerHTML);

            var data = [lineDrawingNumber, photographNumber];

            var bar = new RGraph.Bar({
                id: 'cvs',
                data: data,
                options: {
                    shadows: false,
                    noyaxis: true,
                    ylabels: false,
                    xlabels: {
                        offset: 5
                    },
                    background: {
                        grid: false
                    },
                    axis: {
                        color: 'rgb(102, 102, 102)'
                    },
                    gutter: {
                        left: 125,
                        bottom: 35
                    },
                    text: {
                        font: 'Roboto',
                        size: 12,
                        color: 'rgb(102, 102, 102)'
                    },
                    hmargin: 30,
                    colors: ['rgba(102, 102, 102, 0)', 'rgb(102, 102, 102)', 'rgb(102, 102, 102)', '#ff0', '#0ff', '#0f0'],
                    strokestyle: 'rgb(102, 102, 102)',
                    labels: ['Line Drawing', 'Photograph']
                }
            }).draw();

            var yaxis = new RGraph.Drawing.YAxis({
                id: 'cvs',
                x: 125,
                options: {
                    max: bar.scale2.max,
                    colors: 'rgb(102, 102, 102)',
                    text: {
                        font: 'Roboto',
                        size: 10,
                        color: 'rgb(102, 102, 102)'
                    },
                    gutter: {
                        bottom: 35
                    },
                    title: 'Number of People Who \nFalsely Recalled or Recognized the Lure Word\n',
                }
            }).draw()
        })
    </script>
</body>
</html>