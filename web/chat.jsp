<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="js/status.js"></script>
        <script type="text/javascript" src="js/friends.js"></script>
        <jsp:include page="head.jsp">
	        <jsp:param name="title" value="Chat" />
        </jsp:include>

    </head>
<body>
	<jsp:include page="header.jsp">
		<jsp:param name="title" value="Chat" />
	</jsp:include>
	<main>
        <section id="status-section">
            <h3>Your Status</h3>
            <div class="status-div">
                <p id="status-p">${user.getStatus()}</p>
            </div>
        </section>

        <table id="friends-table">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody id="friends">

            </tbody>
        </table>



        <section id="update-status-section">
            <p>Update status:</p>
            <input type="text" id="status-input">
            <button id="update-status-button" onclick="updateStatus()" value="update-status">Update Status </button>
        </section>
    </main>
	<jsp:include page="footer.jsp">
		<jsp:param name="title" value="Chat" />
	</jsp:include>
</body>
</html>
