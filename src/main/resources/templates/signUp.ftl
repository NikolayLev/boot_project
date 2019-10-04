<#ftl encoding='UTF-8'>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>
<#if message??>

        <div class="form-style-2-heading">
            ${message}
        </div>
    </#if>
<div class="form-style-2">
    <div class="form-style-2-heading">
       Login
    </div>
    <form method="post" action="/signUp">
        <label for="login">Логин
            <br>
            <input class="input-field" type="text" id="login" name="login">
        </label>

        <label for="password">Пароль
            <br>
            <input class="input-field" type="password" id="password" name="password">
        </label>

        <label for="first-name">Имя
            <br>
            <input class="input-field"  id="first-name" name="firstName">
        </label>

        <label for="last-name">Фамилия
            <br>
            <input class="input-field"  id="last-name" name="lastName">
        </label>
        <input type="submit" value="SignUp">
        <br>
    </form>
</div>
</body>
</html>
