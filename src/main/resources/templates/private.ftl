<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Вывод превью изображений перед загрузкой с помощью JavaScript и HTML5 FileReader()</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <style>
        .img-thumbnail {
            height: 75px;
            border: 1px solid #000;
            margin: 10px 5px 0 0;
        }
    </style>
</head>
<body>
<div class="container">


    <div class="row"><label>Загрузить изображение:</label><input type="file" id="file" name="file" /></div><br><br>
    <div class="row"><span id="output"></span></div>
    <br><br>

    <div class="row"><label>Мультизагрузка изображений:</label><input type="file" id="fileMulti" name="fileMulti[]" multiple /></div><br><br>
    <div class="row"><span id="outputMulti"></span></div>
</div>
<script>
    function handleFileSelectSingle(evt) {
        var file = evt.target.files; // FileList object

        var f = file[0]

        // Only process image files.
        if (!f.type.match('image.*')) {
            alert("Только изображения....");
        }

        var reader = new FileReader();

        // Closure to capture the file information.
        reader.onload = (function(theFile) {
            return function(e) {
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


    document.getElementById('file').addEventListener('change', handleFileSelectSingle, false);

    function handleFileSelectMulti(evt) {
        var files = evt.target.files; // FileList object
        document.getElementById('outputMulti').innerHTML = "";
        for (var i = 0, f; f = files[i]; i++) {

            // Only process image files.
            if (!f.type.match('image.*')) {
                alert("Только изображения....");
            }

            var reader = new FileReader();

            // Closure to capture the file information.
            reader.onload = (function(theFile) {
                return function(e) {
                    // Render thumbnail.
                    var span = document.createElement('span');
                    span.innerHTML = ['<img class="img-thumbnail" src="', e.target.result,
                        '" title="', escape(theFile.name), '"/>'].join('');
                    document.getElementById('outputMulti').insertBefore(span, null);
                };
            })(f);

            // Read in the image file as a data URL.
            reader.readAsDataURL(f);
        }
    }


    document.getElementById('fileMulti').addEventListener('change', handleFileSelectMulti, false);

</script>

</body>
</html>