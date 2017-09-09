refreshPersons();

function handleErrors(response) {
    if (!response.ok) {
        var error = new Error(response.statusText);
        error = response;
        throw error;
    }
    return response.json();
}

function errorMessage(errorJson) {
    if (errorJson !== undefined) {
        message = errorJson.message;
        alert(message);
    }
}
function genPersonTable(persons) {

    return persons.map(function (person) {
        return "<tr><td>" + person.id
                + "</td><td>" + person.fName
                + "</td><td>" + person.lName
                + "</td><td>" + person.phone
                + "</td><td>" + "<a href='#' class='btnEdit' id=" + person.id + " data-toggle='modal' data-target='#editPersonModal'>edit</a> / "
                + "<a href='#' class='btnDelete' id=" + person.id + ">delete</a>"
                + "</td></tr>";
    }).join("");
}

function addPerson() {
    var firstName = document.getElementById("firstName1").value;
    var lastName = document.getElementById("lastName1").value;
    var phone = document.getElementById("phone1").value;

    var person = {fName: firstName, lName: lastName, phone: phone};

    var myHeaders = new Headers();
    myHeaders.set('Content-Type', 'application/json');

    //why does it say not found here?
    var promise = fetch("api/person",
            {
                method: "POST",
                headers: myHeaders,
                body: JSON.stringify(person)
            });
    promise.then(handleErrors)
            .then(function (person) {
                alert("Added person" + person.id + ", " + person.fName + ", " + person.lName + ", " + person.phone);
                document.getElementById("firstName1").value = "";
                document.getElementById("lastName1").value = "";
                document.getElementById("phone1").value = "";
                refreshPersons();
            })
            .catch(function (error) {
                return error.json();
            })
            .then(errorMessage);
}

function refreshPersons() {
    var promise = fetch("api/person");
    promise.then(handleErrors)
            .then(function (persons) {
                //create table
                document.getElementById("tableBody").innerHTML = genPersonTable(persons);
            })
            .catch(function (error) {
                console.log("error!!!!!!");
                return error.json();
            })
            .then(errorMessage);
    ;
}

function target() {
    console.log(event.target.className);
    if (event.target.className === "btnDelete") {
        deletePerson(event.target.id);
    }
    if (event.target.className === "btnEdit") {
        setEditPerson(event.target.id);
    }
}

function setEditPerson(targetId) {
    var myHeaders = new Headers();
    myHeaders.set('Content-Type', 'application/json');
    var promise = fetch("api/person/" + targetId,
            {
                method: "GET",
                headers: myHeaders
            });
    promise.then(handleErrors)
            .then(function (person) {
                document.getElementById("editPersonId").innerText = person.id;
                document.getElementById("editFirstName").value = person.fName;
                document.getElementById("editLastName").value = person.lName;
                document.getElementById("editPhone").value = person.phone;
            })
            .catch(function (error) {
                return error.json();
            })
            .then(errorMessage);

}

function editPerson() {

    var personId = document.getElementById("editPersonId").innerText;
    var firstName = document.getElementById("editFirstName").value;
    var lastName = document.getElementById("editLastName").value;
    var phone = document.getElementById("editPhone").value;
    var person = {id: personId, fName: firstName, lName: lastName, phone: phone};

    var myHeaders = new Headers();
    myHeaders.set('Content-Type', 'application/json');
    var promise = fetch("api/person/" + personId,
            {
                method: "PUT",
                headers: myHeaders,
                body: JSON.stringify(person)
            });

    promise.then(handleErrors)
            .then(function (person) {
                alert("Edited: " + person.id + ", " + person.fName + ", " + person.lName + ", " + person.phone + ".");
                refreshPersons();
            })
            .catch(function (error) {
                return error.json();
            })
            .then(errorMessage);
}

function deletePerson(targetId) {
    var myHeaders = new Headers();
    myHeaders.set('Content-Type', 'application/json');
    var promise = fetch("api/person/" + targetId,
            {
                method: "DELETE",
                headers: myHeaders
            }
    );
    promise.then(handleErrors)
            .then(function (person) {
                alert("Delete person: " + person.id + ", " + person.fName + ", " + person.lName + ", " + person.phone + ".");
                refreshPersons();
            })
            .catch(function (errorResponse) {
                return errorResponse.json();
            })
            .then(errorMessage);
}

document.getElementById("editPersonBtnInModal").onclick = editPerson;

document.getElementById("tableBody").addEventListener("click", target);

document.getElementById("addPersonBtn1").addEventListener("click", addPerson);

document.getElementById("refreshTableBtn").onclick = refreshPersons;
