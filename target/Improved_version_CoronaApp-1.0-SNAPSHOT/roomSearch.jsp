<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Contact Tracing @ Campus Proximus"/>
</jsp:include>

<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Rooms search"/>
</jsp:include>

<main>
    <form>
        <table>
            <tr>
                <td><label for="firstName">Firstname</label></td>
                <td><input type="text" id="firstName" name="firstName"></td>
            </tr>
            <tr>
                <td><label for="lastName">Lastname</label></td>
                <td><input type="text" id="lastName" name="lastName"></td>
            </tr>
            <tr>
                <td><label for="date">Date</label></td>
                <td><input type="date" id="date" name="date"></td>
            </tr>
        </table>
        <input type="button" id="searchRoomsButton" value="Search Rooms"/>
        <script type="text/javascript" src="js/rooms.js"></script>
    </form>

    <table>
        <thead>
        <tr>
            <th>Room</th>
            <th>Date</th>
        </tr>
        </thead>
        <tbody id="resultRooms"></tbody>
    </table>
</main>

</body>
</html>