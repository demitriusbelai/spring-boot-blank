<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="pt-br"
      xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Departamentos</title>
        <meta charset="UTF-8"/>
        <meta name="header" content="Departamentos"/>
        <style>
            table td, table th {
                padding: 0.2em;
            }
            form {
                display: inline;
            }
        </style>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                  <th>Departamento</th>
                  <th>Unidade</th>
                  <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${departamentos}" var="departamento">
                    <tr>
                      <td>${departamento.nome}</td>
                      <td>${departamento.unidade.nome}</td>
                      <td>
                          <a href="<c:url value='/departamento/editar/${departamento.id}'/>" class="glyphicon glyphicon-edit btn btn-default btn-xs"></a>
                          <form action="<c:url value='/departamento/excluir/${departamento.id}'/>" method="post">
                                <button class="glyphicon glyphicon-trash btn btn-default btn-xs"></button>
                          </form>
                      </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="<c:url value='/departamento/incluir'/>" class="btn btn-default" type="button">Incluir</a>
    </body>
</html>
