searchRoomsButton = document.getElementById("searchRoomsButton");
searchRoomsButton.onclick = searchRooms;

async function searchRooms() {
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let date = document.getElementById("date").value;

    if (firstName && lastName && date){
        let response = await fetch("Controller?command=Rooms&firstName=" + firstName + "&lastName=" + lastName + "&date=" + date);
        let rooms = await response.json();
        showRooms(rooms);
        await showRooms;
    }

    function showRooms(rooms){
        let roomsTBody = document.getElementById("resultRooms");

        roomsTBody.innerHTML = "";
        for (let i = 0; rooms.length; i++){

            let dateValue = rooms[i].date;
            let date = dateValue.dayOfMonth + "-" + dateValue.monthValue + "-" + dateValue.year;
            roomsTBody.innerHTML += "<tr>" +
                "<td>" + rooms[i].room + "</td>" +
                "<td>" + date + "</td>" +
                "</tr>";
        }
    }
}