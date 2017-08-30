/**
 * 4)
 * a) Yesterday you used the arrays 
 * map and join methods to create an
 * UL with a number of names (ex- 4). 
 * 
 * Use this function+DOM man. to insert 
 * the UL somewhere in an HTML page.
 * 
 * b) Create a FORM with an input field 
 * + a submit button.
 * 
 * c) Add two more buttons to the form with 
 * the text:  “remove first” and  “remove last”. 
 * Implement the behaviour inspired of how 
 * solved part-b. 
 */
var names = ['Bob', 'Knud', 'Jens', 'Lotte'];
function ulGenerator(nameArray) {
    // we use map to add <li> </li> to the new array.
    var newArray = nameArray.map(function (name) {
        return "<li>" + name + "</li>";
    });
    //then we return the string.
    return "<ul>" + newArray.join('') + "</ul>";
}

function filterForName(newName) {
    if (newName === "") {
        return false;
    }
    var filteredNames = names.filter(function (name) {
        return name.toLocaleLowerCase() === newName.toLocaleLowerCase();
    });
    return filteredNames.length === 0;
}

function addName() {
    var name = document.getElementById("nametoadd").value;
    if (filterForName(name)) {
        names.push(name);
    }
    //document.getElementById("mytable").innerHTML = ulGenerator(names);
}

function threeInOne() {
    event.preventDefault();
    switch (event.target.id) {
        case "submitbtn":
            addName();
            break;
        case "removeFirst":
            removeFirst();
            break;
        case "removeLast":
            removeLast();
            break;
        default:
            break;
    }
    document.getElementById("mytable").innerHTML = ulGenerator(names);
}

function removeFirst() {
    names.shift();
}
function removeLast() {
    names.pop();
}


document.getElementById("mytable").innerHTML = ulGenerator(names);
document.getElementById("stopDefault").addEventListener("click", threeInOne);


/*
document.getElementById("submitbtn").onclick = addName;
document.getElementById("removeFirst").onclick = function () {
    names.shift();
    document.getElementById("mytable").innerHTML = ulGenerator(names);
};
document.getElementById("removeLast").onclick = function () {
    names.pop();
    document.getElementById("mytable").innerHTML = ulGenerator(names);
}
*/


