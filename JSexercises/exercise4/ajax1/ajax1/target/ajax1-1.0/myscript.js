function getQuote() {
    /*
     fetch('https://jokes-plaul.rhcloud.com/api/joke')
     .then(function (response) {
     response.json().then(function (data) {
     var str = "<p1> Joke number " + data.id + "<br>" + data.joke + "<br>Source: " + data.reference + "</p1>";
     document.getElementById("quoteJoke").innerHTML = str.toString();
     });
     });*/
    var promise = fetch('https://jokes-plaul.rhcloud.com/api/joke');
    promise.then(function (response) {
        return response.json();//Why return here?
    }).then(function (quote) {

        document.getElementById("joke").innerText = quote.joke;
        document.getElementById("ref").innerText = quote.reference;
        document.getElementById("id").innerText = quote.id;
    });
}
document.getElementById("myBtn").addEventListener("click", getQuote);


