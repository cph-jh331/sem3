function clickHandler() {
    var promise = fetch('QuoteServlet');
    promise.then(function (response) {
        return response.json();//Why return here?
    }).then(function (quote) {

        document.getElementById("joke").innerText = quote.joke;
        document.getElementById("ref").innerText = quote.reference;
        document.getElementById("id").innerText = quote.id;
    });
}

var intervalId;

//everyhour, if you want to do it on specific time then you need a date object.
function start() {
    intervalId = setInterval(clickHandler, 1000 * 60 * 60);
}

document.getElementById("myBtn").onclick = clickHandler;