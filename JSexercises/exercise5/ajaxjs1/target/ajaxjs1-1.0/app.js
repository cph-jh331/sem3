//instead of global var, you could maybe loop through every path to see
//if any of their fill are red.
var lastTargetId = "Hest!";

function infoGen(country) {
    var borders;
    if (country[0].borders.length === 0) {
        borders = "No-one";
    } else {
        borders = country[0].borders.join(", ");
    }
    return "<p>"
            + "Country: " + country[0].name
            + "<br/>Population: " + country[0].population
            + "<br/>Area: " + country[0].area
            + "<br/>Borders: " + borders
            + "</p>";
}

function getStrISO(targetId) {
    var strISO = "https://restcountries.eu/rest/v1/alpha?codes=";
    if (targetId.length <= 2) {
        strISO += targetId;
    } else {
        strISO += targetId.substring(0, targetId.indexOf('-'));
    }
    return strISO;
}

function hitCountry() {
    return event.target.id !== "svg2" && event.target.id !== "Large masses of water";
}

function getInfo() {
    console.log(event.target.id);
    if (hitCountry()) {
        var targetId = event.target.id;
        if (lastTargetId !== "Hest!") {
            document.getElementById(lastTargetId).style.fill = "c0c0c0";
        }
        lastTargetId = targetId;
        document.getElementById(targetId).style.fill = "red";
        var promise = fetch(getStrISO(targetId).toString());
        promise.then(function (response) {
            return response.json();
        }).then(function (country) {
            document.getElementById("insertInfo").innerHTML = infoGen(country).toString();
        });
    }
}


document.getElementById("svg2").addEventListener("click", getInfo);


