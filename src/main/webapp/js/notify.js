window.onload = openSocket;

let webSocket;

notifyButton = document.getElementById("covidPositiveButton");
notifyButton.onclick = notifyContacts;

function openSocket(){
    webSocket = new WebSocket("ws://localhost:8080/notify");
    webSocket.onopen = async function (event){
        console.log("Connection opened");
    };

    webSocket.onmessage = function(event){
        console.log("Message");
        writeResponse(event.data);
    };

    webSocket.onclose = function(event){
        console.log("Connection closed");
    };
}

function writeResponse(text){
    let positives = JSON.parse(text);
    let covidPositiveResults = document.getElementById("covidPositiveResults");

    if (positives[0] === undefined){
        covidPositiveResults.innerHTML += "<tr>" +
            "<td>" + positives.name + "</td>" +
            "<td>" + positives.date + "</td>" +
            "</tr>";
    }
    else {
        covidPositiveResults.innerHTML = "";
        for (let i = 0; i < positives.length; i++) {
            covidPositiveResults.innerHTML += "<tr>" +
                "<td>" + positives[i].name + "</td>" +
                "<td>" + positives[i].date + "</td>" +
                "</tr>";
        }
    }
}

async function notifyContacts() {
    let name = document.getElementById("name").value;
    let date = document.getElementById("date").value;
    webSocket.send(('{ "name" :"' + name + '", "date" :"' + date + '" }'));
}