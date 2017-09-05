
function genPersonTable(persons) {
    var str = "<table id='personTable' class='table'>"
            + "<thead>"
            + "<tr><th>ID</th>"
            + "<th>First Name</th>"
            + "<th>Last Name</th>"
            + "<th>Phone</th></tr>"
            + "</thead>"
            + "<tbody>";
    str += persons.map(function (person) {
        return "<tr><td>" + person.id
                + "</td><td>" + person.fName
                + "</td><td>" + person.lName
                + "</td><td>" + person.phone
                + "</td></tr>";
    }).join("");
    str += "</tbody></table>";
    return str;
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

document.getElementById("refreshTableBtn").onclick = getPersons;