<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="js/blog.js"></script>
    <jsp:include page="head.jsp">
        <jsp:param name="title" value="Home"/>
    </jsp:include>
</head>
<body onload="openSocket();">
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
<main>
    <c:if test="${errors.size()>0 }">
        <div class="danger">
            <ul>
                <c:forEach var="error" items="${errors }">
                    <li>${error }</li>
                </c:forEach>
            </ul>
        </div>
    </c:if> <c:choose>
    <c:when test="${user!=null}">
        <p>Welcome ${user.getFirstName()}!</p>
        <form method="post" action="Controller?action=LogOut">
            <p>
                <input type="submit" id="logoutbutton" value="Log Out">
            </p>
        </form>
    </c:when>
    <c:otherwise>
        <form method="post" action="Controller?action=LogIn">
            <p>
                <label for="email">Your email </label>
                <input type="text" id="email" name="email" value="jan@ucll.be">
            </p>
            <p>
                <label for="password">Your password</label>
                <input type="password" id="password" name="password" value="t">
            </p>
            <p>
                <input type="submit" id="loginbutton" value="Log in">
            </p>
        </form>
    </c:otherwise>
</c:choose>
    <section class="blog">
        <article class="topic">
            <h2>Determinism</h2>
            <p>
                Everything that we know is reducible to the absurd act of chemicals,
                and there is therefore no intristic value in this material universe.
            </p>
            <p>
                replies:
            </p>
            <div id="replies1">

            </div>
            <div class="input">
                <h5>Name</h5>
                <input type="text" id="name1"/>
                <br>
                <h5>Rating (../10)</h5>
                <input type="number" id="rating1"/>
                <br>
                <h5>Comment</h5>
                <input type="text" id="comment1"/>
                <h5>Schoenmaat</h5>
                <input type="number" id="schoenmaat1"/>
            </div>
            <button class="send-button" type="button" onclick="send(1);">Send</button>
        </article>

        <article class="topic">
            <h2>Defining a human</h2>
            <p>
                Can a human be defined as a feathereless biped?
            </p>
            <p>
                replies:
            </p>
            <div id="replies2">

            </div>
            <div class="input">
                <h5>Name</h5>
                <input type="text" id="name2"/>
                <br>
                <h5>Rating (../10)</h5>
                <input type="number" id="rating2"/>
                <br>
                <h5>Comment</h5>
                <input type="text" id="comment2"/>
                <h5>Schoenmaat</h5>
                <input type="number" id="schoenmaat2"/>
            </div>
            <button class="send-button" type="button" onclick="send(2);">Send</button>
        </article>

        <article class="topic">
            <h2>What's the perfect amount of strings on a guitar?</h2>
            <p>For me it's 8</p>
            <p>
                replies:
            </p>
            <div id="replies3">
                 <img src="images/human.jpg" alt="Diogenes holding a featherless chicken">
            </div>
            <div class="input">
                <h5>Name</h5>
                <input type="text" id="name3"/>
                <br>
                <h5>Rating (../10)</h5>
                <input type="number" id="rating3"/>
                <br>
                <h5>Comment</h5>
                <input type="text" id="comment3"/>
                <h5>Schoenmaat</h5>
                <input type="number" id="schoenmaat3"/>
            </div>
            <button class="send-button" type="button" onclick="send(3);">Send</button>
        </article>

        <article class="topic">
            <h2>How many pages can one study in a day?</h2>
            <p>
                For me it varies a lot. On a good day I can study something like 80 or 100 pages,
                on a bad day however I may be unable to study more than 30 or 40.

            </p>
            <p>
                replies:
            </p>
            <div id="replies4">
                 <img src="images/human.jpg" alt="Diogenes holding a featherless chicken">
            </div>
            <div class="input">
                <h5>Name</h5>
                <input type="text" id="name4"/>
                <br>
                <h5>Rating (../10)</h5>
                <input type="number" id="rating4"/>
                <br>
                <h5>Comment</h5>
                <input type="text" id="comment4"/>
                <h5>Schoenmaat</h5>
                <input type="number" id="schoenmaat4"/>
            </div>
            <button class="send-button" type="button" onclick="send(4);">Send</button>
        </article>

        <article class="topic">
            <h2>What is the sound of life?</h2>
            <p>
                What could it possibly be?
            </p>
            <p>
                replies:
            </p>
            <div id="replies5">
                 <img src="images/human.jpg" alt="Diogenes holding a featherless chicken">
            </div>
            <div class="input">
                <h5>Name</h5>
                <input type="text" id="name5"/>
                <br>
                <h5>Rating (../10)</h5>
                <input type="number" id="rating5"/>
                <br>
                <h5>Comment</h5>
                <input type="text" id="comment5"/>
                <h5>Schoenmaat</h5>
                <input type="number" id="schoenmaat5"/>
            </div>
            <button class="send-button" type="button" onclick="send(5);">Send</button>
        </article>

    </section>


</main>

<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
</body>
</html>
