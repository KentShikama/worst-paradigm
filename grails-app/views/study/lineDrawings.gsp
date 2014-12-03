<html>
<head>
    <meta name="layout" content="study"/>
</head>

<body>
<g:each var="item" in="${items}">
    <asset:assetPathExists src="${item.lineDrawingURL}">
        <li style="list-style: none;"><asset:image class="shadow600" src="${item.lineDrawingURL}"/></li>
    </asset:assetPathExists>
</g:each>
</body>
</html>