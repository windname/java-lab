<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>

<%!
    // Declaration block: Class-level field and method
    private int visitCount = 0;

    public String getGreeting(String name) {
        return "Welcome, " + name + "!";
    }
%>

<%
    // Scriptlet: procedural logic runs at request time
    visitCount++;
    String userName = request.getParameter("name");
    if (userName == null || userName.isEmpty()) {
        userName = "Guest";
    }
%>

<h2><%= getGreeting(userName) %></h2> <!-- Expression: output greeting -->

<p>You are visitor number <%= visitCount %></p> <!-- Expression: output count -->

</body>
</html>
