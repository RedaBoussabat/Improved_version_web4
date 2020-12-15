<%--
  Created by IntelliJ IDEA.
  User: RedaB
  Date: 04/12/2020
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
<h1>Contact Tracing @ Campus Proximus</h1>
    <nav>
        <ul>
            <li><a href="Controller">Home</a></li>
            <li><a href="searchPage.jsp">Search</a></li>
            <li><a href="roomSearch.jsp">Rooms</a></li>
            <li><a href="register.jsp">Sign Up</a></li>
            <li><a href="notify.jsp">Notify</a></li>
            <c:choose>
                <c:when test="${user != null}">
                    <li><a href="friends.jsp">Friends</a></li>
                </c:when>
            </c:choose>
        </ul>
    </nav>
    <h2>
        ${param.title}
    </h2>
</header>

