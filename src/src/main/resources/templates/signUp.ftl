<#ftl encoding='UTF-8'>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="/css/styles.css" rel="stylesheet">

    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
</head>
<body>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>


<div class="container mt-1">

    <div class="form-style-2-heading">
        Пожалуйста, зарегистрируйтесь!
        <a href="/login"> Авторизация.</a>
    </div>

    <#if message??>
        <br>
        <div class="alert alert-danger" role="alert">${message}</div>

    </#if>
    <form method="post" action="/signUp">

        <div class="container mt-3">

            <div class="form-group row">
                <label for="login" class="col-sm-1 col-form-label">Логин </label>
                <div class="col-lm-5">
                    <input class="form-control ${(loginError??)?string('is-invalid','')}"
                           type="text" id="login" placeholder="от 4 до 16 Английский букв и цифр" name="login"
                            <#if user.login??> value="${user.login}"</#if>>
                    <#if loginError??>
                        <div class="invalid-feedback">
                            ${loginError}
                        </div>
                    </#if>
                </div>
            </div>

            <div class="form-group row">

                <label for="email" class="col-sm-1 col-form-label">Email </label>
                <div class="col-lm-5">
                    <input class="form-control ${(emailError??)?string('is-invalid','')}"
                           type="email" placeholder="Введите ваш емейл" id="email" name="email"
                            <#if user.email??> value="${user.email}"</#if>>
                    <#if emailError??>
                        <div class="invalid-feedback">
                            ${emailError}
                        </div>
                    </#if>
                </div>
            </div>

            <div class="form-group row">
                <label for="password" class="col-sm-1 col-form-label">Пароль</label>
                <div class="col-lm-5">
                    <input class="form-control ${(passwordError??)?string('is-invalid','')}" type="password"
                           placeholder="Введите пароль" id="password" name="password">

                    <#if passwordError??>
                        <div class="invalid-feedback">
                            ${passwordError}
                        </div>
                    </#if>
                </div>
            </div>
            <div class="form-group row">
                <label for="passwordConfirm" class="col-sm-1 col-form-label">Пароль 2</label>
                <div class="col-lm-5">
                    <input class="form-control ${(passwordConfirmError??)?string('is-invalid','')}" type="password"
                           placeholder="Повторите пароль" id="passwordConfirm" name="passwordConfirm">

                    <#if passwordConfirmError??>
                        <div class="invalid-feedback">
                            ${passwordConfirmError}
                        </div>
                    </#if>
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
            <div class="g-recaptcha" data-sitekey="6LcBBL4UAAAAAMQrvksrMKyvmWh9Vnngs7Ba1rPC"></div>
            <#if captchaError??>
                <div class="alert alert-danger" role="alert">
                    ${captchaError}
                </div>
            </#if>


            <div class="form-group row">
                <button class="btn btn-primary col-lm-5 mr-1" type="submit">SignUp!</button>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </form>
</div>


</div>
</div>
</body>
</html>
