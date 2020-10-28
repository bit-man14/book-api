<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<table>
    <tr>
        <th>object : error</th>
        <th></th>
    </tr>
    <c:forEach var="error" items="${errors}">
        <tr>
            <td>${error}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
