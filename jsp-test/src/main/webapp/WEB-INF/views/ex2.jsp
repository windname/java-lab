<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Elements Example</title>
</head>
<body>
    <h1>JSP Elements Demonstration</h1>

    <!-- 1. jsp:useBean - Instantiates or accesses a JavaBean -->
    <jsp:useBean id="user" class="com.vg.model.UserBean" scope="session"/>

    <!-- 2. jsp:setProperty - Sets bean properties from request parameters -->
    <jsp:setProperty name="user" property="name" param="username"/>
    <jsp:setProperty name="user" property="age" value="30"/>

    <!-- 3. jsp:getProperty - Outputs a bean property -->
    <p>User Name: <jsp:getProperty name="user" property="name"/></p>
    <p>User Age: <jsp:getProperty name="user" property="age"/></p>

    <!-- 4. jsp:include - Dynamically includes another JSP -->
    <h2>
    Included Content:
    <jsp:include page="home.jsp">
        <jsp:param name="extraParam" value="additional data"/>
    </jsp:include>
    </h2>

    <%-- Conditional forward based on some condition --%>
    <% if (request.getParameter("forward") != null) { %>
        <!-- 6. jsp:forward - Forwards the request to another resource -->
        <jsp:forward page="hello.jsp">
            <jsp:param name="message" value="forwarded data"/>
        </jsp:forward>
    <% } %>

    <form method="post" action="example?name=ex2">
        <label for="username">Enter your name:</label>
        <input type="text" id="username" name="username">
        <br>
        <label>
            <input type="checkbox" name="forward" value="true">
            Check to forward to another page
        </label>
        <br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>