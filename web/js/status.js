var xhr = new XMLHttpRequest();

function updateStatus() {
    let statusText = document.getElementById("status-input").value;
    let url = "Controller?action=UpdateStatus&status=" + statusText;
    xhr.open("POST", url , true);
    xhr.onreadystatechange = getStatus;
    xhr.send(null);
    statusText.value = "";
}

function getStatus() {
    if(xhr.status === 200) {
        if(xhr.readyState === 4){
            let serverResponse = JSON.parse(xhr.responseText);
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
    let div = document.getElementById("status-div");
    let p = document.getElementById("status-p");
    p.innerHTML = "";
    let text = document.createTextNode("Online");
    p.appendChild(text);
    p.style.backgroundColor = 'green'
    div.appendChild(p);
}

function away() {
    let div = document.getElementById("status-div");
    let p = document.getElementById("status-p");
    p.innerHTML = "";
    let text = document.createTextNode("Away");
    p.appendChild(text);
    p.style.backgroundColor = 'orange'
    div.appendChild(p);
}

function offline() {
    let div = document.getElementById("status-div");
    let p = document.getElementById("status-p");
    p.innerHTML = "";
    let text = document.createTextNode("Offline");
    p.appendChild(text);
    p.style.backgroundColor = 'red'
    div.appendChild(p);
}

function other(status) {
    let div = document.getElementById("status-div");
    let p = document.getElementById("status-p");
    p.innerHTML = "";
    let text = document.createTextNode(status);
    p.appendChild(text);
    p.style.backgroundColor = 'blue'
    div.appendChild(p);
}
