<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="pt-br"
      xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Departamentos - Cadastro</title>
        <meta charset="UTF-8"/>
        <meta name="header" content="Cadastro"/>
    </head>
    <body>
        <c:url value='/departamento/salvar' var="formAction"/>
        <form:form method="post" action="${formAction}" modelAttribute="departamento">
            <form:input type="hidden" path="id"/>
            <div class="form-group">
                <label for="nome">Nome</label>
                <form:input type="text" id="nome" path="nome"/>
            </div>
            <div class="form-group">
                <label for="unidade">Unidade</label>
                <form:select id="unidade" path="unidade" items="${unidades}"/>
            </div>
            <button type="submit" class="btn btn-primary">Salvar</button>
            <a href="<c:url value='/departamentos'/>" class="btn btn-default" type="button">Cancelar</a>
        </form:form>
    </body>
</html>
