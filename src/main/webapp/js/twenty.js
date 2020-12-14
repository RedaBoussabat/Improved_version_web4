window.onload = updateTwenty;

let registerButton = document.getElementById('registerButton');
registerButton.onclick = addPerson;


let updateTwentyRequest = new XMLHttpRequest();

let newPersonRequest = new XMLHttpRequest();

function updateTwenty() {
    updateTwentyRequest.open("GET", "Controller?command=Home", true);
    updateTwentyRequest.onreadystatechange = showTwenty;
    updateTwentyRequest.send();
}

function showTwenty() {
    if (updateTwentyRequest.readyState === 4) {
        if (updateTwentyRequest.status === 200) {
            let persons = JSON.parse(updateTwentyRequest.responseText);
            let personsTable = document.getElementById("twenty");
            personsTable.innerHTML = "";

            if (personsTable.childNodes.length !== 0) {
                while (personsTable.firstChild) {
                    personsTable.removeChild(personsTable.lastChild);
                }
            }
            personsTable = fillPersonTr(personsTable, persons);
            setTimeout(updateTwenty, 1000);
        }
    }
}

function fillPersonTr(personTable, persons) {

    for (let i = 0; i < persons.length; i++) {
        let personTr = personTable.childNodes[i];
        personTr = document.createElement("tr");
        let firstName = document.createTextNode(persons[i].firstName);
        let lastName = document.createTextNode(persons[i].lastName);
        let dateValue = persons[i].date;
        let day = dateValue.dayOfMonth;
        let month = dateValue.monthValue;
        let year = dateValue.year;
        let date = document.createTextNode(day + "-" + month + "-" + year);
        let room = document.createTextNode(persons[i].room);
        let email = document.createTextNode(persons[i].email);
        let gsm = document.createTextNode(persons[i].gsm);
        let positive = document.createTextNode(persons[i].status);


        let firstNameTd = personTr.childNodes[0];
        let lastNameTd = personTr.childNodes[1];
        let dateTd = personTr.childNodes[2];
        let roomTd = personTr.childNodes[3];
        let emailTd = personTr.childNodes[4];
        let gsmTd = personTr.childNodes[5];
        let positiveTd = personTr.childNodes[5];


        firstNameTd = document.createElement('td');
        firstNameTd.appendChild(firstName);
        personTr.appendChild(firstNameTd);

        lastNameTd = document.createElement('td');
        lastNameTd.appendChild(lastName);
        personTr.appendChild(lastNameTd);

        dateTd = document.createElement('td');
        dateTd.appendChild(date);
        personTr.appendChild(dateTd);

        roomTd = document.createElement('td');
        roomTd.appendChild(room);
        personTr.appendChild(roomTd);

        emailTd = document.createElement('td');
        emailTd.appendChild(email);
        personTr.appendChild(emailTd);

        gsmTd = document.createElement('td');
        gsmTd.appendChild(gsm);
        personTr.appendChild(gsmTd);

        positiveTd = document.createElement('td');
        positiveTd.appendChild(positive);
        personTr.appendChild(positiveTd);

        personTable.appendChild(personTr)
    }
    return personTable;
}

function addPerson() {
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let date = document.getElementById("date").value;
    let room = document.getElementById("room").value;
    let gsm = document.getElementById("gsm").value;

    // Parameter moet & voor hebben staan

    firstName = "firstName=" + encodeURIComponent(firstName);
    lastName = "lastName=" + encodeURIComponent(lastName);
    date = "date=" + encodeURIComponent(date);
    room = "room=" + encodeURIComponent(room);
    gsm = "gsm=" + encodeURIComponent(gsm);


    let information = "command=RegisterContact&" + firstName + "&" + lastName + "&" + date + "&" + room + "&" + gsm;
    newPersonRequest.open("POST", "Controller", true);
    newPersonRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
    newPersonRequest.send(information);
}
