<#ftl encoding='UTF-8'>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

</head>
<body>
        Edit User - ${user1.login}
    <br>
    <form action="/adminPage" method="post">
        <div class="form-group row">
            <label for="colFormLabel" class="col-sm-2 col-form-label">Login</label>
            <div class="col-form-label">
        <input type="text" class="form-control" name="login" value="${user1.login}">
        </div>
        </div>
        <div class="form-group row">
            <label for="colFormLabel" class="col-sm-2 col-form-label">First Name</label>
            <div class="col-form-label">
        <input type="text" class="form-control" name="firstName" value="${user1.firstName}">
            </div>
        </div>
        <div class="form-group row">
            <label for="colFormLabel" class="col-sm-2 col-form-label">Last Name</label>
            <div class="col-form-label">
        <input type="text"  class="form-control" name="lastName" value="${user1.lastName}">
            </div>
        </div>

        <div class="form-check">
            <div class="col-form-label">
        <input class="form-check-input" type="checkbox" id="admin" name="role"
                <#if user1.role == role>
               checked
        </#if>
        >
        <label class="form-check-label" for="admin">Admin Roots</label>
        </div>
        </div>


        <div class="form-check">
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


</body>
</html>