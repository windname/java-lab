<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSTL Examples</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 2em; }
        .example { border: 1px solid #ddd; padding: 1em; margin-bottom: 2em; }
        .example-title { color: #2c3e50; border-bottom: 1px solid #eee; padding-bottom: 0.5em; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h1>JSTL Tag Examples</h1>

    <div class="example">
        <h2 class="example-title">1. &lt;c:set&gt; - Variable Assignment</h2>
        <c:set var="username" value="JohnDoe" scope="page" />
        <c:set var="isAdmin" value="true" scope="session" />
        <p>Username set: <c:out value="${username}" /></p>
    </div>

        <div class="example">
            <h2 class="example-title">2. &lt;c:if&gt; - Conditional Logic</h2>
            <c:if test="${not empty username}">
                <p>Welcome, <c:out value="${username}" />!</p>
            </c:if>
            <c:if test="${isAdmin}">
                <p style="color: green;">You have admin privileges</p>
            </c:if>
        </div>

        <div class="example">
            <h2 class="example-title">3. &lt;c:choose&gt; - Advanced Conditional</h2>
            <c:set var="userLevel" value="3" />
            <c:choose>
                <c:when test="${userLevel == 1}">
                    <p>Basic user</p>
                </c:when>
                <c:when test="${userLevel == 2}">
                    <p>Premium user</p>
                </c:when>
                <c:when test="${userLevel == 3}">
                    <p>Administrator</p>
                </c:when>
                <c:otherwise>
                    <p>Unknown user level</p>
                </c:otherwise>
            </c:choose>
        </div>

            <div class="example">
                <h2 class="example-title">4. &lt;c:forEach&gt; - Looping</h2>
                <c:set var="colors" value="Red,Green,Blue,Yellow,Orange" />
                <h3>Colors List:</h3>
                <ul>
                    <c:forEach items="${colors}" var="color" varStatus="loop">
                        <li>Color ${loop.index + 1}: <c:out value="${color}" /></li>
                    </c:forEach>
                </ul>

                <h3>Users Table:</h3>
                <jsp:useBean id="userBean" class="com.vg.service.UserService" />
                <c:set var="users" value="${userService.getUsers()}" />
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Status</th>
                    </tr>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td><c:out value="${user.id}" /></td>
                            <td><c:out value="${user.name}" /></td>
                            <td><c:out value="${user.email}" /></td>
                            <td>
                                <c:choose>
                                    <c:when test="${user.active}">Active</c:when>
                                    <c:otherwise>Inactive</c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

            <div class="example">
                <h2 class="example-title">5. &lt;c:out&gt; - Safe Output</h2>
                <c:set var="unsafeInput" value="<script>alert('XSS attack!');</script>" />
                <p>Unsafe output (without c:out): ${unsafeInput}</p>
                <p>Safe output (with c:out): <c:out value="${unsafeInput}" /></p>
                <p>Safe output with default: <c:out value="${nonExistentVar}" default="No value provided" /></p>
            </div>

                <div class="example">
                    <h2 class="example-title">6. &lt;c:import&gt; - Import Content</h2>
                    <h3>Local Content:</h3>
                    <c:import url="home.jsp" />

                    <h3>External Content (read-only):</h3>
                    <c:import url="https://google.com" var="externalContent" />
                    <div style="border: 1px solid #ccc; padding: 10px; max-height: 200px; overflow: auto;">
                        <c:out value="${externalContent}" escapeXml="true" />
                    </div>
                </div>

</body>
</html>