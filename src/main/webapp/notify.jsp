<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Contact Tracing @ Campus Proximus"/>
</jsp:include>

<body>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="Notify people"/>
</jsp:include>

<main>
    <form>
        <table>
            <tr>
                <td><label for="name">Name</label></td>
                <td><input type="text" id="name" name="name"></td>
            </tr>
            <tr>
                <td><label for="date">Lastname</label></td>
                <td><input type="date" id="date" name="date"></td>
            </tr>
        </table>
        <input type="button" id="covidPositiveButton" value="Covid-19 positive"/>
    </form>

    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Date</th>
        </tr>
        </thead>
        <tbody id="covidPositiveResults"></tbody>
    </table>
</main>

<script type="text/javascript" src="js/notify.js"></script>
</body>
</html>