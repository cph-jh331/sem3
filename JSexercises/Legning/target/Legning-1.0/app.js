/*
 1) You must use this public REST API  to get data for the exercise:
 Copy the link below into your browser and test. To get a feeling of how to use 
 the API, try (as a minimum) to: remove region, change gender to male, remove 
 gender, change amount to 600;
 
 http://uinames.com/api/?amount=25&region=denmark&gender=female 
 2)  Add the necessary code to (using fetch, the API given above, and 
 DOM-manipulation) render a table as sketched in this figure, when the “Submit” 
 button is pressed.
 
 2a) Add a way to present errors for the users (try and request more than 500 
 names). Hint: Check if the response code is >= 400.
 3) If not already done, find a way (the simplest and acceptable for this 
 exercise, is a global variable, but feel free to come up with better 
 alternatives) to store the data fetched above, so we can reuse it in it’s 
 original form.
 
 4) Add the necessary code to convert (when Get SQL is pressed) the data into 
 valid MySQL syntax that will insert data, into a table with matching columns 
 as sketched in this figure. Insert the generated SQL into the TextArea provided 
 with the startcode. 
 */

var personArray = [];

function genSql() {
    var sqlStr = personArray.map(function (person) {
        return "INSERT INTO names (name, surname, gender) VALUES ("
                + "'" + person.name + "','" + person.surname + "','" + person.gender + "'"
                + ");\n\
";
    }).join("");
    document.getElementById("sql").innerHTML = sqlStr;
}

function genTable(persons) {
    return persons.map(function (person) {
        return "<tr><td>" + person.name + "</td><td>" + person.surname
                + "</td><td>" + person.gender + "</td>";
    }).join("");
}

function genStrLink() {
    var gender = "";
    var amount = "amount=" + document.getElementById("amount").value;
    var region = "";
    if (document.getElementById("gender").value !== "both") {
        gender = "&gender=" + document.getElementById("gender").value;
    }
    if (document.getElementById("region").value !== "All") {
        region = "&region=" + document.getElementById("region").value;
    }
    //http://uinames.com/api/?amount=25&region=denmark&gender=female 
    var str = "http://uinames.com/api/?" + amount + region + gender;
    console.log(str);
    return str;
}

function isInputValid() {
}

function getData() {
    var promise = fetch(genStrLink());

    promise.then(function (response) {
        return response.json();
    }).then(function (persons) {
        personArray = persons;
        console.log(personArray);
        document.getElementById("tblbody").innerHTML = genTable(persons);
    });
}
document.getElementById("btnsql").onclick = genSql;
document.getElementById("btnsend").onclick = getData;







