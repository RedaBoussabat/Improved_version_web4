<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Contact Tracing @ Campus Proximus"/>
</jsp:include>

<body>
<main>

    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Person Overview"/>
    </jsp:include>

    <div>
        <c:choose>
            <c:when test="${user!=null}">
                <p>Welcome, ${user.getFirstName()}!</p>
                <form method="post" action="Controller?command=Logout">
                    <input type="submit" id="logoutButton" value="Log out">
                </form>
            </c:when>
            <c:otherwise>
                <form method="post" action="Controller?command=Login">
                    <table>
                        <tr>
                            <td><label for="mail">Your email</label></td>
                            <td><input type="text" id="mail" name="mail" value="reda.boussabat@ucll.be"></td>
                        </tr>
                        <tr>
                            <td><label for="loginpass">Your password</label></td>
                            <td><input type="text" id="loginpass" name="loginpass" value="t"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" id="loginbutton" value="Log in"></td>
                        </tr>
                    </table>
                </form>
            </c:otherwise>
        </c:choose>

        <table>
            <thead>
            <tr>
                <th>First</th>
                <th>Last</th>
                <th>Date</th>
                <th>Room</th>
                <th>Email</th>
                <th>GSM</th>
                <th>Status</th>
            </tr>
            </thead>
            <tbody id="twenty"></tbody>
        </table>

        <form method="post" action="Controller">
            <table>
                <tr>
                    <td><label for="firstName">First Name</label></td>
                    <td><input type="text" id="firstName" name="firstName" value="test" required></td>
                </tr>
                <tr>
                    <td><label for="lastName">Last Name</label></td>
                    <td><input type="text" id="lastName" name="lastName" value="test" required></td>
                </tr>
                <tr>
                    <td><label for="date">Date</label></td>
                    <td><input type="date" id="date" name="date" required></td>
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
                <tr>
                    <td><label for="gsm">Gsm</label></td>
                    <td><input type="tel" id="gsm" name="gsm" value="0484" required></td>
                </tr>
                <tr>
                    <td><label for="password">Password</label></td>
                    <td><input type="password" id="password" name="password" value="t" required></td>
                </tr>
            </table>
            <input type="button" id="registerButton" value="Register"/>
        </form>
        <script type="text/javascript" src="js/twenty.js"></script>


        <script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
        <script type="text/javascript" src="js/mostrooms.js"></script>
        <table>
            <h3>3 Most visited rooms</h3>
            <tbody id="mostRooms"></tbody>
        </table>
    </div>

</main>
</body>
</html>