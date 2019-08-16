<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page = "header.jsp">
    <jsp:param name = "title" value = "${title}"/>
</jsp:include>

<body>

<jsp:include page = "navigation.jsp"/>

<jsp:include page = "footer.jsp"/>

</body>
</html>
