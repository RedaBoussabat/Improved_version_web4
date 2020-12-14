searchButton = document.getElementById("searchButton");
searchButton.onclick = searchContacts;

async function searchContacts() {
    let date = document.getElementById("date").value;
    let room = document.getElementById("room").value;

    if (date && room){
        let response = await fetch("Controller?command=Search&date=" + date + "&room=" + room)
        let people = await response.json();
        showPeople(people);
        await showPeople;
    }
}

function showPeople(people){
    let peopleTBody = document.getElementById("resultSearch");
    peopleTBody.innerHTML="";
    for (let i = 0; i < people.length; i++){
        peopleTBody.innerHTML += "<tr>" +
            "<td>" + people[i].firstName + "</td>" +
            "<td>" + people[i].lastName + "</td>" +
            "<td>" + people[i].email + "</td>" +
            "<td>" + people[i].gsm + "</td>" +
            "</tr>";
    }
}