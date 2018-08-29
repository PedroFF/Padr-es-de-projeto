

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jspf/header.jspf" %>
    </head>
    <body>
                <%@include file="jspf/nav.jspf" %>
        <h1>Excluir Contato</h1>
        <form action="FrontController?action=ApagarContatoPost" method="post">
            Entre com seu nome para pesquisar:
            <input type="text" name="textNome"/><br/>
            <input type="submit"/>
        </form>
<%@include file="jspf/footer.jspf" %>
