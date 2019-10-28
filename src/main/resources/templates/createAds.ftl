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
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <style>
        .img-thumbnail {
            height: 150px;
            border: 1px solid #000;
            margin: 10px 5px 0 0;
        }
    </style>

</head>
<body>


<div class="container">
    <@n.panel/>
</div>

<div class="container">
    <div class="row">
        <div class="col-sm-4">

            <label>
                <a href="/adsPage/active">Активные объявления:</a> Активные>
            </label>
            <label>
                <a href="/adsPage/delete">Закрытые объявления:</a> Закрытые
            </label>


        </div>
        <div class="col-lg">
            <form method="POST" enctype="multipart/form-data" action="/adsPage/create">


                <div class="form-group row pt-3">
                    <label for="name" class="col-sm-3 col-form-label">Название</label>
                    <div class="col">
                        <input type="text" class="form-control ${(nameError??)?string('is-invalid','')}"
                               <#if product??>value="${product.name}"</#if> name="name" id="name"
                               placeholder="Введите название для объявления">
                        <#if nameError??>
                            <div class="invalid-feedback">
                                ${nameError}
                            </div>
                        </#if>
                    </div>
                </div>
                <div class="form-group row pt-1">
                    <label for="price" class="col-sm-3 col-form-label">Цена</label>
                    <div class="col-sm-3">
                        <input type="number" min="0" class="form-control ${(priceError??)?string('is-invalid','')}"
                                <#if product??> <#if product.price??>value="#{product.price}"</#if> </#if> name="price"
                               id="price" placeholder="Цена">
                        <#if priceError??>
                            <div class="invalid-feedback">
                                ${priceError}
                            </div>
                        </#if>
                    </div>
                </div>

                <div class="form-group pt-1">
                    <label for="description">Описание для товара</label>
                    <textarea class="form-control  ${(descriptionError??)?string('is-invalid','')}"
                              id="description" rows="9" name="description"
                              <#if product??> value="${product.description}"</#if> placeholder="Описание товара"></textarea>
                    <#if descriptionError??>
                        <div class="invalid-feedback">
                            ${descriptionError}
                        </div>
                    </#if>
                </div>

                <div class="container">
                    <label>Загрузить изображение : </label>
                    <input type="file" id="file" <#if file??> value="${file}"  </#if> name="file"/>
                    <button type="submit" class="btn ml-auto btn-primary">Создать</button>
                </div>
                <div class="row"><span id="output"></span></div>

                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </form>
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
            document.getElementById('output').innerHTML = "";
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