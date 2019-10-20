<#ftl encoding='UTF-8'>
<#import "parts/navbar.ftl" as n>

<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

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
<div class="container">
    <@n.panel/>
</div>

<div class="container mt-3">
    <div class="col-sm-4">
        <div class="row">
            <#if image??>
                <img src="/img/${image}" width="240" height="160" class="rounded float-left img-thumbnail"
                     alt="profile image">
            </#if>
        </div>
        <div class="row">
            <div class="container mt-3">
                <form method="POST" enctype="multipart/form-data" action="/profile">
                    <#if image??>Изменить <#else> Добавить </#if> аватар:
                    <div class="form-group">
                        <input type="file" id="file" name="file"/>
                        <span id="output"></span></div>


                    <div class="form-group row my-1">
                        <label for="colFormLabel" class="col-sm-5 col-form-label">Имя</label>
                        <div class="col-form-label">
                            <input type="text" class="form-control" name="firstName" value="${user1.firstName}">
                        </div>
                    </div>
                    <div class="form-group row my-1">
                        <label for="colFormLabel" class="col-sm-5  col-form-label">Фамилия</label>
                        <div class="col-form-label">
                            <input type="text" class="form-control" name="lastName" value="${user1.lastName}">

                        </div>
                    </div>

                    <#if errEmail??>
                        <div class="alert alert-danger" role="alert">Email введен некорректно</div>

                    </#if>
                    <div class="form-group row my-1">
                        <label for="colFormLabel" class="col-sm-5  col-form-label">Email</label>
                        <div class="col-form-label">
                            <input type="text" class="form-control" name="email" value="${user1.email}">

                        </div>
                    </div>
                    <#if errPass??>
                        <div class="alert alert-danger" role="alert">Пароль введен некорректно. Введите от 8 до 16
                            символов(Английские буквы, цифры, символы)
                        </div>
                        <br>
                    </#if>
                    <div class="form-group row my-1">
                        <label for="colFormLabel" class="col-sm-5  col-form-label">Пароль</label>
                        <div class="col-form-label">
                            <input type="text" class="form-control" name="password" value="">

                        </div>
                    </div>

                    <div class="form-group row my-1 pl-3 mt-2">
                        <button type="submit" class="btn btn-primary">Изменить</button>
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                </form>


            </div>

        </div>
    </div>
</div>

<script>
    function handleFileSelectSingle(evt) {
        var file = evt.target.files; // FileList object

        var f = file[0]

        // Only process image files.
        if (!f.type.match('image.*')) {
            alert("Только изображения....");
            document.getElementById('file').value = null;
        } else {

            var reader = new FileReader();

            // Closure to capture the file information.
            reader.onload = (function (theFile) {
                return function (e) {
                    // Render thumbnail.
                    var span = document.createElement('span');
                    span.innerHTML = ['<img class="img-thumbnail" src="', e.target.result,
                        '" title="', escape(theFile.name), '"/>'].join('');
                    document.getElementById('output').innerHTML = "";
                    document.getElementById('output').insertBefore(span, null);
                };
            })(f);

            // Read in the image file as a data URL.
            reader.readAsDataURL(f);
        }
    }

    document.getElementById('file').addEventListener('change', handleFileSelectSingle, false);


</script>

</body>
</html>
