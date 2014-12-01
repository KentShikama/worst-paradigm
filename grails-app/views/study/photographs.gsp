<html>
<head>
    <meta name="layout" content="study"/>
</head>

<body>
<g:each var="item" in="${items}">
    <asset:assetPathExists src="${item.photographURL}">
        <li><asset:image src="${item.photographURL}"/></li>
    </asset:assetPathExists>
</g:each>
</body>
</html>