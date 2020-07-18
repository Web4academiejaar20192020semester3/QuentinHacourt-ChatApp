var getStatusRequest = new XMLHttpRequest();
var updateStatusRequest = new XMLHttpRequest();

function updateStatus() {
    var statusText = document.getElementById("status-input").value;
    alert(statusText)
    updateStatusRequest.open("POST", "Controller?action=UpdateStatus&status=" + statusText , true);
    updateStatusRequest.onreadystatechange = getStatus;
    updateStatusRequest.send(null);
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
    document.getElementById("status-div").style.backgroundColor = 'green';
    document.querySelector("status-p").textContent = 'Online';
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
