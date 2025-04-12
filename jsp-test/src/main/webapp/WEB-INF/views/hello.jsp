<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Hello JSP</title>
</head>
<body>
    <h1>Message:</h1>
        <p>${message}</p>
        <!-- Alternative using JSTL -->
        <p><c:out value="${message}"/></p>
    <p>Current time: <%= new java.util.Date() %></p>
</body>
</html>