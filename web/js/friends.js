window.onload = fetchFriends;

var xhr = new XMLHttpRequest();

function addFriend() {
    let friendId = document.getElementById("friendId");
    xhr.open("POST", "Controller?action=AddFriend&friendId=" + friendId.value , true);
    xhr.onreadystatechange = fetchFriends;
    xhr.send(null);
    friendId.value = "";
}

function fetchFriends(){
    xhr.open("GET","Controller?action=GetFriends", true);
    xhr.onreadystatechange = getFriends;
    xhr.send(null);
    // TODO: add timer
    // setTimeout(fetchFriends, 5000);
}

function getFriends() {
    if(xhr.status === 200) {
        if(xhr.readyState === 4){
            clearTable();
            let serverResponse = JSON.parse(xhr.responseText);
            let friendsTable = document.getElementById("friends-table");
            // let count = 1;
            for(let person in serverResponse){
                let tr = document.createElement("tr");
                let tdName = document.createElement("td");
                let tdStatus = document.createElement("td");
                tdName.innerText = serverResponse[person].name;
                tdStatus.innerText = serverResponse[person].status;

                tr.appendChild(tdName);
                tr.appendChild(tdStatus);
                tr.className = "friendlist";
                friendsTable.appendChild(tr);
                // count++;
            }
            timeoutId = setTimeout(fetchFriends,20000);
        }
    }
}

function clearTable(){
    let friends = document.querySelectorAll('.friendlist');
    let tableBody = document.getElementById('friends-table');
    for (let i=0;i<friends.length;i++){
        tableBody.removeChild(friends[i]);
    }
}
