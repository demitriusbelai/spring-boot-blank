<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="pt-br"
      xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Unidade - Cadastro</title>
        <meta charset="UTF-8"/>
        <meta name="header" content="Cadastro"/>
        <style>
            table td, table th {
                padding: 0.2em;
            }
        </style>
        <script>
            function removerTelefone(index) {
                $('form').attr('action', '<c:url value="/unidade/telefone/remover/"/>' + index).submit();
            }
            function adicionarTelefone() {
                $('form').attr('action', '<c:url value="/unidade/telefone/adicionar"/>').submit();
            }
        </script>
    </head>
    <body>
        <c:url value='/unidade/salvar' var="formAction"/>
        <form:form method="post" action="${formAction}" modelAttribute="unidade">
            <form:input type="hidden" path="id"/>
            <div class="form-group">
                <label for="nome">Nome</label>
                <form:input type="text" id="nome" path="nome"/>
            </div>
            <div class="form-group">
                <label>Telefones</label>
                <table id="telefones">
                    <thead>
                        <tr>
                            <th>DDD</th>
                            <th>Numero</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${unidade.telefones}" var="telefone" varStatus="stat">
                            <tr>
                                <td>
                                    <form:input type="hidden" path="telefones[${stat.index}].id"/>
                                    <form:input type="text" path="telefones[${stat.index}].ddd"/>
                                </td>
                                <td>
                                    <form:input type="text" path="telefones[${stat.index}].numero"/>
                                </td>
                                <td>
                                    <button type="button" class="glyphicon glyphicon-trash btn btn-default btn-xs" onclick="removerTelefone('${stat.index}')"></button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="3">
                                <button type="button" class="btn btn-default" onclick="adicionarTelefone()">Novo Telefone</button>
                            </td>
                        </tr>
                    </tfoot>
                </table>
            </div>
            <button type="submit" class="btn btn-primary">Salvar</button>
            <a href="<c:url value='/unidades'/>" class="btn btn-default" type="button">Cancelar</a>
        </form:form>
    </body>
</html>
