getPersons();
function genPersonTable(persons) {
    var str = "<table id='personTable' class='table'>"
            + "<thead>"
            + "<tr><th>ID</th>"
            + "<th>First Name</th>"
            + "<th>Last Name</th>"
            + "<th>Phone</th>"
            + "<th></th></tr>"
            + "</thead>"
            + "<tbody>";
    str += persons.map(function (person) {
        return "<tr><td>" + person.id
                + "</td><td>" + person.fName
                + "</td><td>" + person.lName
                + "</td><td>" + person.phone
                + "</td><td>" + "<a href='#' class='btndelete' id=" + person.id + ">delete</a> / "
                + "<a href='#' class='btnedit' id=" + person.id + ">edit</a>"
                + "</td></tr>";
    }).join("");
    str += "</tbody></table>";
    return str;
}
//<a href="#" class="btndelete" id="1">delete</a>

function addPerson() {
    var firstName = document.getElementById("firstName").value;
    var lastName = document.getElementById("lastName").value;
    var phone = document.getElementById("phone").value;

    var person = {fName: firstName, lName: lastName, phone: phone};

    var myHeaders = new Headers();
    myHeaders.set('Content-Type', 'application/json');

    var promise = fetch("api/person",
            {
                method: "POST",
                headers: myHeaders,
                body: JSON.stringify(person)
            });
    promise.then(function (response) {
        return response.json();
    }).then(function (person) {
        alert("Added person" + person.id + ", " + person.fName + ", " + person.lName + ", " + person.phone);
        document.getElementById("firstName").value = "";
        document.getElementById("lastName").value = "";
        document.getElementById("phone").value = "";
        getPersons();
    });
}

function getPersons() {
    var promise = fetch("api/person");
    promise.then(function (response) {
        return response.json();
    }).then(function (persons) {
        //create table
        document.getElementById("tableDiv").innerHTML = genPersonTable(persons);
    });
}

function target() {


}

document.getElementById("addPersonBtn").addEventListener("click", addPerson);

document.getElementById("refreshTableBtn").onclick = getPersons;