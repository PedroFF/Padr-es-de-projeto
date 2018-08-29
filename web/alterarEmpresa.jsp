<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jspf/header.jspf" %>
        <title>Alterar Empresa</title>
    </head>
    <body>
                <%@include file="jspf/nav.jspf" %>
        <h1>Alterar Contato</h1>
        <form action="FrontController?action=AlterarEmpresaPost" method="post">
            Entre com seu nome para pesquisar:
            <input type="text" name="textNome"/><br/>
            E-mail:
            <input type="text" name="textEmail"/><br/>
            <input type="submit"/>
        </form>
<%@include file="jspf/footer.jspf" %>
