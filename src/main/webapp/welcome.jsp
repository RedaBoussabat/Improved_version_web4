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
        <jsp:param name="title" value="Welcome"/>
    </jsp:include>

    <div>
        <h2>Follow these guidelines</h2>
        <div id="guidelines">
            <p>Wear a face mask</p>
            <p class="important">Over your nose</p>
            <p>Wash your hands with soap</p>
            <p class="important">regulary and for 20 seconds</p>
            <p>Stay at a safe distance from others</p>
            <p class="important">Even thoughout the holidays</p>
        </div>
    </div>
    <script src="js/jquery-1.4.4.min.js"></script>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/welcome.js"></script>

</main>
</body>
</html>