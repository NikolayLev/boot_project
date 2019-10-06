<#ftl encoding='UTF-8'>
<#import "parts/navbar.ftl" as n>

<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<div class="container">
    <@n.panel/>
</div>
<div class="container mt-2">
    <h2>
Edit User - ${user1.login}
        </h2>
    <br>
    <form action="/adminPage" method="post">
        <div class="form-group row my-1">
            <label for="colFormLabel" class="col-sm-2 col-form-label">Login</label>
            <div class="col-form-label">
        <input type="text" class="form-control" name="login" value="${user1.login}">
        </div>
        </div>
        <div class="form-group row my-1">
            <label for="colFormLabel" class="col-sm-2 col-form-label">First Name</label>
            <div class="col-form-label">
        <input type="text" class="form-control" name="firstName" value="${user1.firstName}">
            </div>
        </div>
        <div class="form-group row my-1">
            <label for="colFormLabel" class="col-sm-2 col-form-label">Last Name</label>
            <div class="col-form-label">
        <input type="text"  class="form-control" name="lastName" value="${user1.lastName}">
            </div>
        </div>

        <div class="form-check">
            <div class="col-form-label my-1">
        <input class="form-check-input" type="checkbox" id="admin" name="role"
                <#if user1.role == role>
               checked
        </#if>
        >
        <label class="form-check-label my-1" for="admin">Admin Roots</label>
        </div>
        </div>


        <div class="form-check my-1">
            <div class="col-form-label">
        <input class="form-check-input" type="checkbox" id="status" name="status"
        <#if user1.state == status>
            checked
        </#if>
        >
        <label class="form-check-label" for="status">Active</label>

        </div>
        </div>
        <input type="hidden" value="${user1.id}" name = "userId">
        <button class="btn btn-primary" type="submit">Изменить данные</button>

    </form>
</div>

</body>
</html>