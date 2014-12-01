<html>
<head>
    <meta name="layout" content="study"/>
</head>

<body>
<g:each var="item" in="${items}">
    <asset:assetPathExists src="${item.lineDrawingURL}">
        <li><asset:image src="${item.lineDrawingURL}"/></li>
    </asset:assetPathExists>
</g:each>
</body>
</html>