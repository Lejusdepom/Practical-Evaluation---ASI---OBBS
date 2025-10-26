<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>Borrowed Books</title></head>
<body>
<h2>Your Borrowed Books</h2>

<c:if test="${empty borrowedBooks}">
    <p>You haven’t borrowed any books yet.</p>
</c:if>

<c:if test="${not empty borrowedBooks}">
<table border="1" cellpadding="5">
    <tr>
        <th>ISBN</th>
        <th>Title</th>
        <th>Author</th>
        <th>Format</th>
        <th>Action</th>
    </tr>
    <c:forEach var="book" items="${borrowedBooks}">
        <tr>
            <td>${book.isbn}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.format}</td>
            <td>
                <form action="return" method="post">
                    <input type="hidden" name="isbn" value="${book.isbn}">
                    <button type="submit">Return</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</c:if>

<p><a href="catalog">Back to Catalog</a></p>
<p><a href="checkout">See the Checkout page</a></p>

</body>
</html>