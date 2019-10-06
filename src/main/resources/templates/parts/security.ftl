<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
>
<#if known>
    <#assign
        userDetails = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        user = userDetails.getUser()
        name = user.getLogin()
        isAdmin = user.isAdmin()
    >
    <#else>
    <#assign
        name = "unknown"
        isAdmin = false
    >
</#if>