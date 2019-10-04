<#ftl encoding='UTF-8'>
<#import "parts/template.ftl" as l>

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Admin Page!
    </div>
    <@l.logout/>
    <table>
        <thead>
        <tr>
            <th>UserName</th>
            <th>Role</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.login}</td>
                <td>${user.role.name()}</td>
                <td>${user.state.name()}</td>
                <td><a href="/adminPage/${user.id}">edit</a> </td>
            </tr>
        </#list>
        </tbody>
    </table>

</div>
</body>
</html>