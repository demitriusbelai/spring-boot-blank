<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="pt-br"
      xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Unidades</title>
        <meta charset="UTF-8"/>
        <meta name="header" content="Unidades"/>
        <style>
            table td, table th {
                padding: 0.2em;
            }
        </style>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                  <th>Departamento</th>
                  <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${unidades}" var="unidade">
                    <tr>
                      <td>${unidade.nome}</td>
                      <td>
                          <a href="<c:url value='/unidade/editar/${unidade.id}'/>" class="glyphicon glyphicon-edit btn btn-default btn-xs"></a>
                      </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
