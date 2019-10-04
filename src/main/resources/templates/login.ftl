<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Please Login!
        <#if error??>
            <br>
            <div class="alert alert-danger" role="alert">Логин или пароль введены неверно</div>
        </#if>
    </div>
    <form method="post" action="/login">
        <label for="login">Логин
            <br>
            <input class="input-field" type="text" id="login" name="login">
        </label>

        <label for="password">Пароль
            <br>
            <input class="input-field" type="password" id="password" name="password">
        </label>
        <label for="remember-me">
            <input type="checkbox" id="remember-me" name="remember-me">Запомнить меня</label>
        <input type="submit" value="Login">
    </form>
</div>
</body>
</html>
