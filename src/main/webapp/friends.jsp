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
        <jsp:param name="title" value="Friends"/>
    </jsp:include>


    <script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="js/friends.js"></script>
    <div>
        <form method="post" action="Controller?command=Register">
            <table>
                <tr>
                    <td><label for="email">Email</label></td>
                    <td><input type="text" id="email" name="email" value="reda.boussabat@ucll.be" required></td>
                </tr>
            </table>
            <input type="button" id="addFriendButton" value="Add Friend"/>
        </form>

        <table>
            <tbody id="friendList"></tbody>
        </table>
    </div>
</main>
</body>
</html>
