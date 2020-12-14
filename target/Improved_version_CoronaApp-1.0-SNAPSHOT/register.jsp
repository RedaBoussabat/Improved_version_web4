<%--
  Created by IntelliJ IDEA.
  User: RedaB
  Date: 13/12/2020
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Contact Tracing @ Campus Proximus"/>
</jsp:include>

<body>
<main>
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Sign Up"/>
    </jsp:include>

    <form method="post" action="Controller?command=Register">
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
                <td><label for="password">Password</label></td>
                <td><input type="password" id="password" name="password" value="t" required></td>
            </tr>
        </table>
        <input type="submit" id="registerUserButton" value="Register"/>
    </form>
</main>
</body>
</html>
