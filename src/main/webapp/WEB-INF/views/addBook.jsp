<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<form:form method="post" modelAttribute="book" action="${pageContext.request.contextPath}/books/addBook">
    <p hidden><form:input path="id"/></p>
    <label for="isbn">ISBN</label>
    <form:input path="isbn" id="isbn"/>
    <form:errors path="isbn"/>
    <br>
    <label for="title">Title</label>
    <form:input path="title" id="title"/>
    <form:errors path="title"/>
    <br>
    <label for="publisher">Publisher</label>
    <form:input path="publisher" id="publisher"/>
    <form:errors path="publisher"/>
    <br>

    <label for="author">Author</label>
    <form:input path="author" id="author"/>
    <form:errors path="author"/>
    <br>
    <label for="type">Type</label>
    <form:input path="type" id="type"/>
    <form:errors path="type"/>
    <br>


    <input type="submit" value="Save">
</form:form>
</body>
</html>