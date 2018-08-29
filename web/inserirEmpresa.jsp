<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<%@include file="jspf/header.jspf" %>
<title>Administração de Contato</title>
</head>
<body>
    <%@include file="jspf/nav.jspf" %>
    <h1>Cadastro de Empresa</h1>
    <form action="FrontController?action=GravarEmpresaPost" method="post">
        Entre com seu nome
        <input type="text" name="textNome"/><br/>
        <input type="submit"/>
    </form>

    <%@include file="jspf/footer.jspf" %>