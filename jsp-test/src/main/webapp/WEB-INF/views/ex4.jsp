<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSTL Formatting Tags Examples</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 2em; }
        .example { border: 1px solid #ddd; padding: 1em; margin-bottom: 2em; }
        .example-title { color: #2c3e50; border-bottom: 1px solid #eee; padding-bottom: 0.5em; }
        table { border-collapse: collapse; width: 100%; margin-top: 1em; }
        th, td { border: 1px solid #ddd; padding: 8px; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h1>JSTL Formatting (fmt) Tag Examples</h1>

    <!-- 1. Setting Locale and Resource Bundles -->
    <div class="example">
    <!-- Load the default bundle first -->
    <fmt:setBundle basename="com.vg.messages" var="appBundle"/>

    <!-- 1. Default Locale -->
    <h2>Default Locale:</h2>
    <fmt:setLocale value="${pageContext.request.locale}"/>
    <p><fmt:message key="welcome.message" bundle="${appBundle}"/></p>

    <!-- 2. French Locale -->
    <h2>French Locale:</h2>
    <fmt:setLocale value="fr_FR"/>
    <fmt:setBundle basename="com.vg.messages" var="frenchBundle"/>
    <p><fmt:message key="welcome.message" bundle="${frenchBundle}"/></p>

    <!-- 3. German Locale -->
    <h2>German Locale:</h2>
    <fmt:setLocale value="de_DE"/>
    <fmt:setBundle basename="com.vg.messages" var="germanBundle"/>
    <p><fmt:message key="welcome.message" bundle="${germanBundle}"/></p>

    <!-- 4. Japanese Locale -->
    <h2>Japanese Locale:</h2>
    <fmt:setLocale value="ja_JP"/>
    <fmt:setBundle basename="com.vg.messages" var="japaneseBundle"/>
    <p><fmt:message key="welcome.message" bundle="${japaneseBundle}"/></p>

    <!-- 5. Explicit Bundle -->
    <h2>With Explicit Bundle:</h2>
    <p><fmt:message key="app.title" bundle="${appBundle}"/></p>
    </div>

    <!-- 2. Formatting Dates -->
    <div class="example">
        <h2 class="example-title">2. Date Formatting</h2>
        <jsp:useBean id="now" class="java.util.Date" />

        <table>
            <tr>
                <th>Style</th>
                <th>Date</th>
                <th>Time</th>
                <th>Both</th>
            </tr>
            <tr>
                <td>Default (SHORT)</td>
                <td><fmt:formatDate value="${now}" type="date" /></td>
                <td><fmt:formatDate value="${now}" type="time" /></td>
                <td><fmt:formatDate value="${now}" type="both" /></td>
            </tr>
            <tr>
                <td>MEDIUM</td>
                <td><fmt:formatDate value="${now}" type="date" dateStyle="medium" /></td>
                <td><fmt:formatDate value="${now}" type="time" timeStyle="medium" /></td>
                <td><fmt:formatDate value="${now}" type="both" dateStyle="medium" timeStyle="medium" /></td>
            </tr>
            <tr>
                <td>Custom Pattern</td>
                <td colspan="3">
                    <fmt:formatDate value="${now}" pattern="EEEE, MMMM d, yyyy 'at' hh:mm:ss a z" />
                </td>
            </tr>
        </table>
    </div>

    <!-- 3. Formatting Numbers -->
    <div class="example">
        <h2 class="example-title">3. Number Formatting</h2>
        <c:set var="price" value="12345.6789" />

        <table>
            <tr>
                <th>Type</th>
                <th>Format</th>
                <th>Result</th>
            </tr>
            <tr>
                <td>Currency</td>
                <td>&lt;fmt:formatNumber value="${price}" type="currency" /&gt;</td>
                <td><fmt:formatNumber value="${price}" type="currency" /></td>
            </tr>
            <tr>
                <td>Percent</td>
                <td>&lt;fmt:formatNumber value="0.25" type="percent" /&gt;</td>
                <td><fmt:formatNumber value="0.25" type="percent" /></td>
            </tr>
            <tr>
                <td>Pattern</td>
                <td>&lt;fmt:formatNumber value="${price}" pattern="#,##0.00" /&gt;</td>
                <td><fmt:formatNumber value="${price}" pattern="#,##0.00" /></td>
            </tr>
            <tr>
                <td>Grouping</td>
                <td>&lt;fmt:formatNumber value="1000000" groupingUsed="true" /&gt;</td>
                <td><fmt:formatNumber value="1000000" groupingUsed="true" /></td>
            </tr>
            <tr>
                <td>Max Fraction Digits</td>
                <td>&lt;fmt:formatNumber value="${price}" maxFractionDigits="2" /&gt;</td>
                <td><fmt:formatNumber value="${price}" maxFractionDigits="2" /></td>
            </tr>
        </table>
    </div>

    <!-- 4. Parsing Dates and Numbers -->
    <div class="example">
        <h2 class="example-title">4. Parsing</h2>

        <h3>Date Parsing:</h3>
        <fmt:parseDate value="2023-12-25" pattern="yyyy-MM-dd" var="christmas" />
        Parsed date: <fmt:formatDate value="${christmas}" pattern="MMMM d, yyyy" />

        <h3>Number Parsing:</h3>
        <fmt:parseNumber value="1,234.56" var="parsedNumber" />
        Parsed number: <fmt:formatNumber value="${parsedNumber}" type="currency" />
    </div>

    <!-- 5. Time Zone Handling -->
    <div class="example">
        <h2 class="example-title">5. Time Zones</h2>

        <fmt:setTimeZone value="GMT" var="gmtTime" />
        <fmt:setTimeZone value="America/New_York" var="nyTime" />
        <fmt:setTimeZone value="Asia/Tokyo" var="tokyoTime" />

        <table>
            <tr>
                <th>Time Zone</th>
                <th>Current Time</th>
            </tr>
            <tr>
                <td>Server Default</td>
                <td><fmt:formatDate value="${now}" type="both" /></td>
            </tr>
            <tr>
                <td>GMT</td>
                <td><fmt:formatDate value="${now}" timeZone="${gmtTime}" type="both" /></td>
            </tr>
            <tr>
                <td>New York</td>
                <td><fmt:formatDate value="${now}" timeZone="${nyTime}" type="both" /></td>
            </tr>
            <tr>
                <td>Tokyo</td>
                <td><fmt:formatDate value="${now}" timeZone="${tokyoTime}" type="both" /></td>
            </tr>
        </table>
    </div>
</body>
</html>