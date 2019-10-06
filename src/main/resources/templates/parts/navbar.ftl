<#include "security.ftl">
<#macro panel>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent" >
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/uploadForm">UploadForm</a>
            </li>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/adminPage">adminPage</a>
            </li>
            </#if>
            <li class="nav-item">
                <a class="nav-link" href="/signUp">SignUp</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/login">Login</a>
            </li>
        </ul>
        <div class="navbar-text mr-3"> ${name} </div>

            <form class="form-inline" action="/logout" method="post">
            <button class="btn btn-sm btn-outline-secondary mt-1" type="submit">Sign Out</button>

            </form>


    </div>
</nav>
</#macro>