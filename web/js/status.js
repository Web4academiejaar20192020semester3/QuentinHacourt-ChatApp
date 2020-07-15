var getStatusRequest = new XMLHttpRequest();
var updateStatusRequest = new XMLHttpRequest();

function updateStatus() {
    var statusText = document.getElementById("status_input").value;
    var information = "status=" + encodeURIComponent(statusText);
    updateStatusRequest.open("POST", "ManageStatusServlet", true);
    newQuoteRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    newQuoteRequest.send(information);
}

function checkStatus() {
    getStatusRequest.open("GET", "ManageStatusServlet", true);
    getStatusRequest.onreadystatechange = getStatus();
    getStatusRequest.send(null);
}

function getStatus() {
    if(getStatusRequest.status === 200) {
        if(setStatusRequest.readyState === 4){
            let serverResponse = JSON.parse(getStatusRequest.responseText);
            let status = serverResponse.status;
            switch(status.toLowerCase()){
                case "online":
                    online();
                    break;
                case "away":
                    away();
                    break;
                case "offline":
                    offline();
                    break;
                default:
                    other(status);
            }
        }
    }
}

function online() {
    // TODO: check if this sets background color to green and text to "Online"
    document.getElementById("status").style.backgroundColor = 'green';
    document.querySelector("statusText").textContent = 'Online';
}

function away() {
    document.getElementById("status").style.backgroundColor = 'orange';
    document.querySelector("statusText").textContent = 'Away';
}

function offline() {
    document.getElementById("status").style.backgroundColor = 'red';
    document.querySelector("statusText").textContent = 'Offline';
}

function other(text) {
    document.getElementById("status").style.backgroundColor = 'blue';
    document.querySelector("statusText").textContent = text;
}
