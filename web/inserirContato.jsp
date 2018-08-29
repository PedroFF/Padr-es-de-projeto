<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<%@include file="jspf/header.jspf" %>
<title>Administração de Contato</title>
</head>
<body>
    <%@include file="jspf/nav.jspf" %>
    <h1>Cadastro de Contatos</h1>
    <form action="FrontController?action=GravarContatoPost" method="post">
        Entre com seu nome
        <input type="text" name="textNome"/><br/>
        Entre com seu email
        <input type="text" name="textEmail"/><br/>
        <select name ="selectEmpresa">
            <c:forEach var="empresa" items="${empresas}">
                <option value="${empresa.id}">${empresa.nome}</option>
            </c:forEach>
        </select>
        <input type="submit"/>
    </form>

    <%@include file="jspf/footer.jspf" %>