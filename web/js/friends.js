window.onload = fetchFriends;

var xhr = new XMLHttpRequest();

function addFriend() {
    let friendId = document.getElementById("add-friend-id").value;
    let url = "Controller?action=AddFriend&friendId=" + friendId;
    xhr.open("POST", url , true);
    xhr.onreadystatechange = fetchFriends;
    xhr.send(null);
    friendId.value = "";
}

function fetchFriends(){
    xhr.open("GET","Controller?action=GetFriends", true);
    xhr.onreadystatechange = getFriends;
    xhr.send(null);
}

function getFriends() {
    let onlineTeller = 0;
    let offlineTeller = 0;
    if(xhr.status === 200) {
        if(xhr.readyState === 4){
            // clearTable();
            let serverResponse = JSON.parse(xhr.responseText);
            let friendsTable = document.getElementById("friends-table");
            friendsTable.innerHTML = "";
            for(let person in serverResponse){
                if (serverResponse[person].status.toLowerCase() === "online") {
                    onlineTeller++;
                } else if (serverResponse[person].status.toLowerCase() === "offline") {
                    offlineTeller++;
                }
                let tr = document.createElement("tr");
                let tdName = document.createElement("td");
                let tdStatus = document.createElement("td");
                tdName.innerText = serverResponse[person].name;
                tdStatus.innerText = serverResponse[person].status;

                tr.appendChild(tdName);
                tr.appendChild(tdStatus);
                tr.className = "friendlist";
                friendsTable.appendChild(tr);
            }

            let onlineRow = document.createElement("tr");
            let td1 = document.createElement("td");
            let td2 = document.createElement("td");
            td1.innerText = "online friends:";
            td2.innerText = onlineTeller;
            onlineRow.appendChild(td1);
            onlineRow.appendChild(td2);

            let offlineRow = document.createElement("tr");
            let tdOffline1 = document.createElement("td");
            let tdOffline2 = document.createElement("td");
            tdOffline1.innerText = "offline friends:"
            tdOffline2.innerText = offlineTeller;

            offlineRow.appendChild(tdOffline1);
            offlineRow.appendChild(tdOffline2);

            friendsTable.appendChild(onlineRow);
            friendsTable.appendChild(offlineRow);

            timeoutId = setTimeout(fetchFriends, 1000);
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
