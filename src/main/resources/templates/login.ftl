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
        Please Login!
    </div>
        <#if error??>
            <br>
            <div class="alert alert-danger" role="alert">Логин или пароль введены неверно</div>
        </#if>
    </div>
<form method="post" action="/login">
<div class= "container mt-3">
        <div class="form-group row">

            <label for="login" class="col-sm-1 col-form-label">Логин </label>
            <div class="col-lm-5">
            <input class="form-control" type="text" id="login" name="login">
            </div>
        </div>

         <div class="form-group row">

             <label for="password" class="col-sm-1 col-form-label">Пароль</label>
             <div class="col-lm-5">
            <input class="form-control" type="password" id="password" name="password">
             </div>
         </div>

    <div class="form-group row">
        <button class="btn btn-primary col-sm-1" type="submit">Login</button>
                <div class="form-check mt-2 pl-5">

                <input type="checkbox" class="form-check-input" id="remember-me" name="remember-me">
                <label class="form-check-label" for="remember-me">Запомнить меня</label>
                </div>
            </div>
    </div>
</div>
    </form>


</body>
</html>
