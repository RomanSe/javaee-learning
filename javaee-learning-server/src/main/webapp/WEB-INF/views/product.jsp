<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="header.jsp">
    <jsp:param name="title" value="${title}"/>
</jsp:include>
<body>

<jsp:include page="navigation.jsp"/>

<form>
    <input type="text" id="id" hidden value="${product.id}">
    <div class="form-group">
        <label>Product # <c:out value="${product.id}"/></label>
    </div>
    <div class="form-row">
        <c:url value="/images/${product.image}" var="imageUrl"/>
        <div class="form-group">
            <img src="${imageUrl}">
        </div>
        <div class="form-group">
            <input type="text" class="form-control"  name="name" id="inputName" placeholder="Name" value="${product.name}">
        </div>
    </div>
    <div class="form-group">
        <label for="inputDescription">Description</label>
        <input type="text" class="form-control" name="description" id="inputDescription" placeholder="Description"
               value="${product.description}">
    </div>
    <button type="submit" class="btn btn-primary" formmethod="post">Submit</button>
</form>

<jsp:include page="footer.jsp"/>

</body>
</html>
