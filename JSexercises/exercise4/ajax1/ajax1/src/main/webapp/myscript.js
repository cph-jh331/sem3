function getQuote() {
    fetch('https://jokes-plaul.rhcloud.com/api/joke')
            .then(function (response) {
                response.json().then(function (data) {
                    var str = "<p1> Joke number " + data.id + "<br>" + data.joke + "<br>Source: " + data.reference + "</p1>";
                    document.getElementById("quoteJoke").innerHTML = str.toString();
                });
            });
}

document.getElementById("myBtn").addEventListener("click", getQuote);


