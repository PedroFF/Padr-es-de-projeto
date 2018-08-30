<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jspf/header.jspf" %>
<title>Alterar Empresa</title>
</head>
<body>
    <%@include file="jspf/nav.jspf" %>
    <h1>Alterar Empresa</h1>
    <table>
        <thead>
        <th>Id</th>
        <th>Empresa</th>
    </thead>
    <tbody>
    <c:forEach items="${empresas}" var="empresa">
        <tr>
        <td>${empresa.getId()}</td>
        <td>${empresa.getNome()}</td>
        </tr>
    </c:forEach>
    <br/>
</tbody>
</table>
<form action="FrontController?action=AlterarEmpresaPost" method="post">
    Entre com o id da empresa para pesquisar:
    <input type="text" name="id"/><br/>
    Nome:
    <input type="text" name="nome"/><br/>
    <input type="submit"/>
</form>
<%@include file="jspf/footer.jspf" %>
