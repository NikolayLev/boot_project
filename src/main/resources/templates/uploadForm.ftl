<#ftl encoding='UTF-8'>

<html>
<body>


</div>

<div>

    <form method="POST" enctype="multipart/form-data" action="/uploadForm">
        <table>
            <tr><td>File to upload:</td><td><input type="file" name="file" /></td></tr>
            <tr><td></td><td><input type="submit" value="Upload" /></td></tr>
        </table>
    </form>
</div>
<#if image??>
<img src="/img/${image}">
</#if>


</body>
</html>