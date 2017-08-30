/**
 * 6) Implement a calculator with functionality as given below.
 * a.When a button is clicked the value should be appended to 
 * the display div (middle figure)
 * 
 * b. When the equal sign is clicked the result of the calculation 
 * should be displayed. (last figure)
 * 
 * c. Use the HTML and Style given below to get started
 */


function appendButton() {
    var str = document.getElementById("display").innerHTML;
    var eventValue = event.target.innerHTML;
    if (eventValue !== "=") {
        str += eventValue;
    }
    document.getElementById("display").innerHTML = str;
}

function mul(displayValue) {
    var mullArray = displayValue.split("*");
    var result = 1;
    for (number in mullArray) {
        result *= Number(mullArray[number]);
    }
    return result;
}

function div(displayValue) {
    var divArray = displayValue.split("/");
    var result = divArray.shift();
    for (number in divArray) {
        result /= Number(divArray[number]);
    }
    return result;
}

function add(displayValue) {
    addArray = displayValue.split("+");
    var result = 0;
    for (number in addArray) {
        result += Number(addArray[number]);
    }
    return result;
}

function sub(displayValue) {
    var result = 0;
    subArray = displayValue.split("-");
    if (displayValue.charAt(0) !== "-") {
        result = subArray.shift();
    }
    for (number in subArray) {
        result -= Number(subArray[number]);
    }
    return result;
}

function calculate() {
    event.stopPropagation();
    var displayValue = document.getElementById("display").innerHTML;
    var result = 0;
    if (displayValue.indexOf("*") != -1) {
        result = mul(displayValue);
    }
    if (displayValue.indexOf("/") != -1) {
        result = div(displayValue);
    }
    if (displayValue.indexOf("+") != -1) {
        result = add(displayValue);
    }
    if (displayValue.indexOf("-") != -1) {
        result = sub(displayValue);
    }
    document.getElementById("display").innerHTML = result.toString();
}

document.getElementById("buttons").addEventListener("click", appendButton);
document.getElementById("calculate").addEventListener("click", calculate);
