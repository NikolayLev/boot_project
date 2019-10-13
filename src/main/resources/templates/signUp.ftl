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

    <div class="form-style-2-heading">
        Пожалуйста, зарегистрируйтесь!
        <a href="/login"> Авторизация.</a>
    </div>

    <#if message??>
        <br>
        <div class="alert alert-danger" role="alert">${message}</div>

    </#if>
    <form method="post" action="/signUp">

        <div class= "container mt-3">
            <#if invalidLogin??>
                <div class="alert alert-danger" role="alert">Логин введен некорректно. Введите от 4 до 16 символов(Английские буквы, цифры</div>
                <br>
            </#if>
            <div class="form-group row">
                <label for="login" class="col-sm-1 col-form-label">Логин </label>
                <div class="col-lm-5">
                    <input class="form-control" type="text" id="login" placeholder="от 4 до 16 Английский букв и цифр" name="login">
                </div>
            </div>
            <#if invalidEmail??>
                <div class="alert alert-danger" role="alert">Email введен некорректно</div>

            </#if>
            <div class="form-group row">

                <label for="email" class="col-sm-1 col-form-label">Email </label>
                <div class="col-lm-5">
                    <input class="form-control" type="email" placeholder="Введите ваш емейл" id="email" name="email">
                </div>
            </div>
            <#if invalidPassword??>
                <div class="alert alert-danger" role="alert">Пароль введен некорректно. Введите от 8 до 16 символов(Английские буквы, цифры, символы)</div>
                <br>
            </#if>
            <div class="form-group row">
                <label for="password" class="col-sm-1 col-form-label">Пароль</label>
                <div class="col-lm-5">
                    <input class="form-control" type="password" placeholder="Введите пароль" id="password" name="password">
                </div>
            </div>

            <div class="form-group row">

            <label for="firstName" class="col-sm-1 col-form-label">Имя</label>
            <div class="col-lm-5">
                <input class="form-control" type="text" id="firstName" name="firstName">
            </div>
        </div>

            <div class="form-group row">

            <label for="lastName" class="col-sm-1 col-form-label">Фамилия</label>
            <div class="col-lm-5">
                <input class="form-control" type="text" id="lastName" name="lastName">
            </div>
        </div>

            <div class="form-group row">
                <button class="btn btn-primary col-lm-5 mr-1" type="submit">SignUp!</button>

            </div>
        </div>
    </form>
</div>

</div>
</div>
</body>
</html>
