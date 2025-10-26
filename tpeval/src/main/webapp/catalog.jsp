<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Book Catalog</title>
</head>
<body>
<h2>Available Books</h2>

<table border="1" cellpadding="5">
    <tr>
        <th>ISBN</th>
        <th>Title</th>
        <th>Author</th>
        <th>Available Copies</th>
        <th>Description</th>
        <th>Action</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.isbn}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.availableCopies}</td>
            <td>${book.description}</td>
            <td>
                <form action="reserve" method="post">
                    <input type="hidden" name="isbn" value="${book.isbn}" />
                    <button type="submit">Borrow</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<p><a href="borrowed">See the Borrowed books list</a></p>

</body>
</html>