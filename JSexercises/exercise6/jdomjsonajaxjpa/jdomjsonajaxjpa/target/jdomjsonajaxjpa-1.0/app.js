
function genSql(persons) {
    return  persons.map(function (person) {
        return "INSERT INTO names (name, surname, gender) VALUES ("
                + "'" + person.name + "','" + person.surname + "','" + person.gender + "'"
                + ");";
    }).join("");
}

function addTableData(persons) {
    return persons.map(function (person) {
        return "<tr><td>" + person.name + "</td><td>" + person.surname + "</td><td>" + person.gender + "</td>";
    }).join("");
}

function genLink() {
    var gender = "";
    if (document.getElementById("gender").value !== "both") {
        gender = "&gender=" + document.getElementById("gender").value;
    }
    var region = document.getElementById("region").value;
    var amount = document.getElementById("amount").value;
    return "http://uinames.com/api/?amount=" + amount + "&region=" + region + gender;
}

function checkValue() {
    return document.getElementById("amount").value <= 500;
}

function getSql() {
    if (checkValue()) {
        var promise = fetch(genLink());
        promise.then(function (response) {
            return response.json();
        }).then(function (persons) {
            console.log(persons);
            document.getElementById("sql").innerText = genSql(persons);
            document.getElementById("tblbody").innerHTML = addTableData(persons);
        });
    } else {
        alert("amount is to high");
    }
}

document.getElementById("btnsend").addEventListener("click", getSql);






