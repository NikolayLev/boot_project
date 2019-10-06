<#ftl encoding='UTF-8'>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<div class= "container mt-1">
<#if message??>

        <div class="form-style-2-heading">
            ${message}
        </div>
    </#if>
<div class="form-style-2">
    <div class="form-style-2-heading">
       SignUp
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
</div>
</body>
</html>
