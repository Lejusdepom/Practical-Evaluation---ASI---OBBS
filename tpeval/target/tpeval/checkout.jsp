<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout - Online Book Borrowing System</title>
</head>
<body>
<h2>Checkout Summary</h2>

<c:if test="${not empty error}">
    <p class="error">${error}</p>
</c:if>

<c:if test="${not empty message}">
    <p class="message">${message}</p>
</c:if>

<c:if test="${not empty borrowedBooks}">
    <table border = 1 cellpadding="5">
        <tr>
            <th>ISBN</th>
            <th>Title</th>
            <th>Author</th>
            <th>Format</th>
            <th>Cost (euro/month)</th>
        </tr>
        <c:forEach var="book" items="${borrowedBooks}">
            <tr>
                <td>${book.isbn}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.format}</td>
                <td>
                    <c:choose>
                        <c:when test="${book.format == 'physical'}">10</c:when>
                        <c:otherwise>5</c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>

    <h3>Total Monthly Cost: ${totalCost} euro(s)</h3>

    <c:if test="${empty error}">
        <form action="checkout" method="post">
            <input type="submit" value="Confirm Checkout">
        </form>
    </c:if>
</c:if>

<p><a href="borrowed">Back to Borrowed books list</a></p>

</body>
</html>