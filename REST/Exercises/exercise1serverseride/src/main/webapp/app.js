function getRandomQuote() {
    var myHeaders = new Headers();
    myHeaders.set('Content-Type', 'application/json');
    var promise = fetch("api/quote/random", {
        method: "GET",
        headers: myHeaders
    });
    promise.then(function (response) {
        return response.json();
    }).then(function (quote) {
        document.getElementById("quoteOfTheDay").innerText = quote.quote;
    });
}

function getSpecificQuote() {
    var id = document.getElementById("quoteId").value;
    if (id !== "") {
        console.log(id);
        var myHeaders = new Headers();
        myHeaders.set('Content-Type', 'application/json');
        var promise = fetch("api/quote/" + id, {
            method: "GET",
            headers: myHeaders
        });
        promise.then(function (response) {
            return response.json();
        }).then(function (quote) {
            console.log(quote);
            document.getElementById("quoteForDeletion").value = quote.quote;
        });
    }
}

function deleteQuote() {
    var id = document.getElementById("quoteId").value;
    var myHeaders = new Headers();
    myHeaders.set('Content-Type', 'application/json');
    var promise = fetch("api/quote/" + id,
            {
                method: "DELETE",
                headers: myHeaders
            }
    );
    promise.then(function (response) {
        return response.json();
    }).then(function (quote) {
        document.getElementById("quoteOfTheDay").innerText = "Deleted quote: "
                + quote.quote + " with id: " + quote.id;
        document.getElementById("quoteForDeletion").value = "";
    });
}

function editQuote() {
    var id = document.getElementById("quoteId").value;
    var quote = {id: id, quote: document.getElementById("quoteForDeletion").value};
    var data = JSON.stringify(quote);
    var myHeaders = new Headers();
    myHeaders.set('Content-Type', 'application/json');
    var promise = fetch("api/quote/" + id,
            {
                method: "PUT",
                headers: myHeaders,
                body: data
            });
    promise.then(function (response) {
        return response.json();
    }).then(function (quote) {
        document.getElementById("quoteOfTheDay").innerText = "Edited quote to: "
                + quote.quote + " with the id of " + quote.id;
        document.getElementById("quoteForDeletion").value = "";
    });
}

function addQuote() {
    var qText = document.getElementById("inputText").value;
    var quote = {quote: qText};
    var data = JSON.stringify(quote);
    var myHeaders = new Headers();
    myHeaders.set('Content-Type', 'application/json');
    var promise = fetch("api/quote/1",
            {
                method: "POST",
                headers: myHeaders,
                body: data}
    );
    promise.then(function (response) {
        return response.json();
    }).then(function (quote) {
        document.getElementById("quoteOfTheDay").innerText = "Added: " + quote.quote + " with id=" + quote.id;
    });
    document.getElementById("inputText").value = "";
}


document.getElementById("quoteId").addEventListener("keyup", getSpecificQuote);
document.getElementById("getNewQuote").onclick = getRandomQuote;
document.getElementById("addNewQuote").onclick = addQuote;
document.getElementById("deleteQuoteBtn").onclick = deleteQuote;
document.getElementById("editQuoteBtn").onclick = editQuote;


