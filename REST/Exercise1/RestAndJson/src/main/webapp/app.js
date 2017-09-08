function buildTable(persons) {
    return persons.map(function (person) {
        return "<tr><td>" + person.id
                + "</td><td>" + person.fName
                + "</td><td>" + person.lName
                + "</td><td>" + person.age
                + "</td></tr>";
    }).join("");
}

function genDataTable() {
    var sizeOfPersons = document.getElementById("numberOfPersons").value;
    var startId = document.getElementById("startId").value;
    var myHeaders = new Headers();
    myHeaders.set('Content-Type', 'application/json');
    var promise = fetch("api/data/" + sizeOfPersons + "/" + startId,
            {
                method: "GET",
                headers: myHeaders
            });
    promise
            .then(function (response) {
                return response.json();
            })
            .then(function (persons) {
                document.getElementById("tableBody").innerHTML = buildTable(persons)
            });
}

document.getElementById("refreshTableBtn").addEventListener("click", genDataTable);


