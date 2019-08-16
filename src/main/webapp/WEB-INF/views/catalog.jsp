<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="header.jsp">
    <jsp:param name="title" value="${title}"/>
</jsp:include>
<body>

<jsp:include page="navigation.jsp"/>

<table class="table table-hover">
    <thead class="thead-dark">
    <tr>
        <th scope="col"></th>
        <th scope="col">Name</th>
        <th scope="col">Description</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${requestScope.products}">
        <c:url value="/product" var="productUrl">
            <c:param name="id" value="${product.id}"/>
        </c:url>
        <c:url value="/images/${product.image}" var="imageUrl"/>

        <tr>
            <td><a href="${productUrl}"><img src="${imageUrl}"></a></td>
            <td><a href="${productUrl}"><c:out value="${product.name}"/></a></td>
            <td><c:out value="${product.description}"/></td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<jsp:include page="footer.jsp"/>

</body>
</html>
