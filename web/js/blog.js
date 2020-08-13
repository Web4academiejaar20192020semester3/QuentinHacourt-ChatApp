var webSocket;
var messages;

function openSocket() {
    webSocket = new WebSocket("ws://localhost:8080/ChatApp_war_exploded/echo");

    webSocket.onmessage = function(event){
        writeResponse(event.data);
    };
}

function send(topicId) {
    let comment = document.getElementById("comment" + topicId).value;
    let name = document.getElementById("name" + topicId).value;
    let rating = document.getElementById("rating" + topicId).value;
    let schoenmaat = document.getElementById("schoenmaat" + topicId).value;
    if (comment.length == 0 || name.length == 0 ||
        rating.length == 0 || isNaN(rating) ||
        schoenmaat.length == 0 || isNaN(schoenmaat)) {
        alert("Some fields are empty!")
    } else if (rating > 10 || rating < 0) {
        alert("Rating is not a number between 0 and 10!");
    } else {
        let message = "<p>rating: " + rating + "/10</p><p>name: " + name + "</p><p>" + comment + "</p><p>schoenmaat: " + schoenmaat + "</p>";
        webSocket.send(JSON.stringify({id: topicId, comment: message}));
    }
}

function closeSocket() {
    webSocket.close();
    alert("socket closed");
}

function writeResponse(text) {
    let serverResponse = JSON.parse(text);
    let topicId = serverResponse.id;
    let comment = serverResponse.comment;
    messages = document.getElementById("replies" + topicId);
    messages.innerHTML += comment;
}
