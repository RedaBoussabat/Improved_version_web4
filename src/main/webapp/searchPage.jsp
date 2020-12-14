<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Contact Tracing @ Campus Proximus"/>
</jsp:include>

<body>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="Search Page"/>
</jsp:include>

<main>
    <form>
        <table>
            <tr>
                <td><label for="date">Date</label></td>
                <td><input type="date" id="date" name="date"></td>
            </tr>
            <tr>
                <td><label for="room">Rooms</label></td>
                <td>
                    <select name="room" id="room">
                        <option value="C001">C001</option>
                        <option value="C002">C002</option>
                        <option value="C003">C003</option>
                        <option value="C004">C004</option>
                    </select>
                </td>
            </tr>
        </table>
        <input type="button" id="searchButton" value="Search Persons"/>
        <script type="text/javascript" src="js/search.js"></script>
    </form>

    <table>
        <thead>
        <tr>
            <th>First</th>
            <th>Last</th>
            <th>Email</th>
            <th>GSM</th>
        </tr>
        </thead>
        <tbody id="resultSearch"></tbody>
    </table>
</main>
</body>
</html>