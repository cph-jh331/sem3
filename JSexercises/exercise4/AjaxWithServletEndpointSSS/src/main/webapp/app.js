
function genPersonTable(personArray) {
    return personArray.map(function (person) {
        return "<tr><td>" + person.fName + "</td><td>" + person.lName
                + "</td><td>" + person.phone + "</td></tr>";
    }).join('');
}


function makePersonTable() {
    var myHeaders = new Headers();
    myHeaders.append("X-Custom-Header", "givfstuff");
    var myInit = {method: "GET", headers: myHeaders};

    var promise = fetch('PersonServlet', myInit);
    promise.then(function (response) {
        return response.json();//Why return here?
    }).then(function (persons) {
        personArray = persons;
        var personsStr = genPersonTable(persons);
        document.getElementById("personTable").innerHTML = personsStr.toLocaleString();
    });
}

function addPersonToArray() {
    var firstName = document.getElementById("firstName").value;
    var lastName = document.getElementById("lastName").value;
    var phone = document.getElementById("phoneNumb").value;

    //need checks if the input is empty or not valid.

    var person = {fName: firstName, lName: lastName, phone: phone};

    var data = JSON.stringify(person);

    var myHeaders = new Headers();
    myHeaders.set('Content-Type', 'application/json');
    myHeaders.append("X-Custom-Header", "addstuff");

    var promise = fetch("PersonServlet",
            {
                method: "POST",
                headers: myHeaders,
                body: data
            });
    promise.then(function (response) {
        return response.json();
    }).then(function (persons) {
        var personsStr = genPersonTable(persons);
        document.getElementById("personTable").innerHTML = personsStr.toLocaleString();
    });
}

document.getElementById("btnAddPerson").onclick = addPersonToArray;




