var friendsRequest = new XMLHttpRequest();
var addNewFriendRequest

function getFriends() {
    getFriendsRequest.open("GET", "Controller?action=Friendlist", true);
    getFriendsRequest.onreadystatechange = getStatus();
    getFriendsRequest.send(null);
    setTimeout(getPeople, 1000);
}

function showFriends() {
    if(getFriendsRequest.status === 200) {
        if(setStatusRequest.readyState === 4){
            let serverResponse = JSON.parse(getFriendsRequest.responseText);
            let friends = serverResponse.friends;
            // TODO: do something with friends
            clearTable();
            let serverResponse = JSON.parse(friendsRequest.responseText);
            let friends = document.getElementById("friends");
            let count = 1;
            for(let person in serverResponse){
                let tr = document.createElement("tr");
                let tdName = document.createElement("td");
                let tdStatus = document.createElement("td");
                tdName.innerText = serverResponse[person].name;
                tdStatus.innerText = serverResponse[person].status;

                tr.appendChild(tdName);
                tr.appendChild(tdStatus);
                tr.className = "friendlist";
                friends.appendChild(tr);
                count++;
            }
            timeoutId = setTimeout(getFriendlist,20000);
        }
    }
}

function clearTable(){
    let friends = document.querySelectorAll('.friendlist');
    let table = document.getElementById('friends');
    for (let i=0;i<friends.length;i++){
        table.removeChild(friends[i]);
    }
}

function addNewFriend() {
    let friendId = document.getElementById("friendId");
    let url = "Controller?action=AddFriend&friendId=" + friendId.value;
    addNewFriendRequest.open("GET", url, true);
    addNewFriendRequest.send(null);
    friendId.value = "";
}
