<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>ISBN</th>
        <th>Title</th>
        <th>Author</th>
        <th>Publisher</th>
        <th>Type</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.isbn}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.publisher}</td>
            <td>${book.type}</td>
            <td><a href="/books/confirm/${book.id}">Delete</a></td>
            <th><a href="/books/editBook/${book.id}">Edit</a></th>
        </tr>
    </c:forEach>
</table>

<h2>
    <a href="/books/addBook">Add Book</a>
</h2>
<br>
<form:form method="get" action="${pageContext.request.contextPath}/books/filter">
    <label for="author">Author:</label>
    <input type="text" id="author" name="author" value=""><br><br>

    <label for="title">Title:</label>
    <input type="text" id="title" name="title" value=""><br><br>
    <input type="submit" value="Filter">
</form:form>
</body>
</html>
