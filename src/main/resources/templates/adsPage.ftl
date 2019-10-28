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

</head>
<body>


<div class="container">
    <@n.panel/>
</div>

<div class="container mt-2">
    <div class="row">
        <div class="col-sm-4">

            <label>
                <a href="/adsPage/active">Активные объявления:</a> Активные
            </label>
            <label>
                <a href="/adsPage/delete">Закрытые объявления:</a> Закрытые
            </label>


        </div>
        <div class="col-sm-8">

            <#if productList??>
                <#list productList as product>

                    <a href="/adsPage/edit/${product.id}" class="btn btn-secondary btn btn-block">
                        <i class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></i> ${product.name}
                    </a>
                    <#if product.fileName??>
                        <img src="/img/product/${product.fileName}" class="img-fluid rounded mx-auto d-block"
                             alt="Responsive image">
                    </#if>

                    <div class="border border-secondary">
                        <p class="font-weight-bolder">Описание:</p>
                        <span style="white-space: pre-line">${product.description}</span></div>

                    <p class="font-weight-bolder mt-2"> Цена: ${product.price}руб. </p>
                    <p class="text-right">${product.date}</p>
                </#list>
            <#else>
                ${message}
            </#if>
        </div>

    </div>
</div>
</body>
</html>