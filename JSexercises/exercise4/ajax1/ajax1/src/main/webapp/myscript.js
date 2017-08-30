function getQuote() {
    fetch('https://jokes-plaul.rhcloud.com/api/joke').then(function (response) {
        response.json().then(function (data) {
            var str = "<p1>" + data.id + " " + data.joke + "<br>ref:" + data.reference + "</p1>";
            document.getElementById("quoteJoke").innerHTML = str;
        });
    });
}

document.getElementById("myBtn").addEventListener("click", getQuote);


