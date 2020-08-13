$(function(){
    $("#get-messages-btn").click(function(){
        let friendID = $("#chat-friend-id").val();
        getMessages(friendID);
    });

    $("#send-message-btn").click(function(){
        let friendID = $("#chat-friend-id").val();
        let content = $("#message-content").val();

        sendMessage(friendID, content);
        getMessages(friendID);
    });
    // TODO: add function for delete message button
});

function sendMessage(friendID, content){
        $.post({
            url: "Controller?action=AddMessage",
            data: {content: content, friendID: friendID},
        });
}

function getMessages(friendID){
    let url = "Controller?action=GetChat&friendID=" + friendID
    $.get({
        url: url,
        success: function (res) {
            addMessages(res);
        },
        error: function () {
            alert("Failed to load chat");
        },
        dataType: "json"
    });
}

function addMessages(json){
    $("#conversation").empty();
    for (let i = 0; i < json.length; i++) {
        let message = document.createElement("p");  // Create with DOM
        message.innerText = json[i].senderID + ": " + json[i].content;
        let button = document.createElement("button");
        button.innerText = "Delete";
        button.onclick = function () {
            deleteMessage(json[i].messageID);
        };


        $('#conversation').append(message);
        $('#conversation').append(button);
    }
}

function deleteMessage(messageID){
    let url = "Controller?action=DeleteMessage"
    $.post({
        url: url,
        data: {messageID: messageID}
    });
    getMessages($("#chat-friend-id").val());
}
