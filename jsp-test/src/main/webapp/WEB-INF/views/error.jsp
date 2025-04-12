<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error Page</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .error-container { border: 2px solid #ff0000; padding: 20px; background-color: #ffeeee; }
        .error-title { color: #ff0000; }
        pre { background-color: #f5f5f5; padding: 10px; overflow-x: auto; }
    </style>
</head>
<body>
    <h1 class="error-title">Error Occurred</h1>

    <div class="error-container">
        <h2>Error Details</h2>

        <p><strong>Status Code:</strong> ${pageContext.errorData.statusCode}</p>
        <p><strong>Request URI:</strong> ${pageContext.errorData.requestURI}</p>
        <p><strong>Servlet Name:</strong> ${pageContext.errorData.servletName}</p>

        <h3>Exception:</h3>
        <p>${pageContext.exception}</p>

        <h3>Stack Trace:</h3>
        <pre>
<%
    if (exception != null) {
        java.io.PrintWriter pw = new java.io.PrintWriter(out);
        exception.printStackTrace(pw);
    }
%>
        </pre>

        <h3>Additional Information:</h3>
        <p>Timestamp: <%= new java.util.Date() %></p>
    </div>

    <p><a href="javascript:history.back()">Back to Previous Page</a></p>
</body>
</html>