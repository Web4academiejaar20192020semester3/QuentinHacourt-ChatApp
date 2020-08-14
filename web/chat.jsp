<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="js/status.js"></script>
    <script type="text/javascript" src="js/friends.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/chat.js"></script>
    <jsp:include page="head.jsp">
        <jsp:param name="title" value="Chat"/>
    </jsp:include>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Chat"/>
</jsp:include>
<main>
    <section id="status-section">
        <h3>Your Status</h3>
        <div class="status-div">
            <p id="status-p">${user.getStatus()}</p>
        </div>
    </section>

    <table id="friends-table">
        <thead id="friends-header">
        <tr>
            <th>Name</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody id="friends-table-body">

        </tbody>
    </table>


    <section id="update-status-section">
        <p>Update status:</p>
        <input type="text" id="status-input">
        <button id="update-status-button" onclick="updateStatus()" value="update-status">Update Status</button>
    </section>

    <section id="add-friend-section">
        <p>add friend:</p>
        <input type="text" id="add-friend-id">
        <button onclick="addFriend()">Add friend</button>
    </section>

    <section id="chat-section">
        <div id="choose-friend">
            <p>
                 Who do you want to chat with?
            </p>
            <input type="text" id="chat-friend-id" name="chat-friend-id"/>
            <button id="get-messages-btn" type="button">
                 Start chatting
            </button>
        </div>

        <div id="conversation">

        </div>
        <div id="send-message-div">
            <input type="text" value="message" id="message-content">
            </input>
            <button type="submit" id="send-message-btn">
                Send
            </button>
        </div>
    </section>
        <input type="text" id="search-friend-id">
        <button id="search-friend-btn">Search Friend</button>
        <div id="search-result">

        </div>
    <section id="search-friend">


    </section>

</main>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Chat"/>
</jsp:include>
</body>
</html>
