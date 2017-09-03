function getRandomQuote() {
    var promise = fetch("http://localhost:8080/exercise1serverseride/api/quote/random");
    promise.then(function (response) {
        return response.json();
    }).then(function (quote) {
        document.getElementById("quoteOfTheDay").innerText = quote.quote;
    });
}

document.getElementById("getNewQuote").onclick = getRandomQuote;