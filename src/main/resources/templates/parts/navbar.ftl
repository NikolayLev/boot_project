<#include "security.ftl">
<#macro panel>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/profile">Профиль</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="/adsPage">Мои объявления</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/adsPage/create">Подать объявление</a>
            </li>




            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/adminPage">adminPage</a>
            </li>
            </#if>


        </ul>
        <div class="navbar-text mr-3">
            <#if image??>
                <img src="/img/${image}" width="auto" height="24" class="rounded"
                     alt="profile image">
            </#if>
            ${name}

            <a href="/logout" class="btn btn-sm btn-outline-secondary" role="buton">Logout</a></div>




    </div>
</nav>
</#macro>