<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jspf/header.jspf" %>
        <title>Ler Contato</title>
    </head>
    <body>
        <%@include file="jspf/nav.jspf" %>
        <h1>Ler Contatos</h1>
        <form action="FrontController?action=LerContatoPost" method="post">
            Entre com seu nome para pesquisar:
            <input type="text" name="textNome"/><br/>
            E-mail:
            <h1></h1><br/>
            <c:choose>
                <c:when test="${not empty contato}">
                    <h1>${contato.email}</h1>
                    <h1>${contato.empresa.nome}</h1>
                </c:when>
                <c:otherwise>
                    <h1>Informe o nome</h1>
                </c:otherwise>
            </c:choose>

            <input type="submit"/>
        </form>
<%@include file="jspf/footer.jspf" %>
