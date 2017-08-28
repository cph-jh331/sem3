/*
    JavaScript Functions.
    1) Create a new JavaScript file and add these three 
    functions.
*/

function add(n1, n2) {
    return n1 + n2;
}

var sub = function (n1, n2) {
    return n1 - n2;
};

/*
    3) Error Handling
        written after part 2)...
*/

var cb = function (n1, n2, callback) {

    try {
        if (typeof n1 !== "number") {
            throw new Error("n1 is not a number");
        } else if (typeof n2 !== "number") {
            throw new Error("n2 is not a number");
        } else if (typeof callback !== "function") {
            throw new Error("callback is not a function");
        } else {
            return "Result from the two numbers: " + n1 + "+" + n2 + "=" + callback(n1, n2);
        }
    } catch (e) {
        return e.name + ': ' + e.message;
    }
};

/*
    2) Call the functions above as sketched below. 
    It’s not about doing it as fast as you can, but 
    about understanding what's happening, so make 
    sure you understand each line.
*/

//this should return 3:
console.log(add(1, 2));
//Wasn't sure what it would return, but it returns the function as typed:
console.log(add);
//Returns the sum of 1+2 and ignores the last parameter. Does not throw an error:
console.log(add(1, 2, 3));
//Returns as a NaN value, because you are trying to add to an non existent element:
console.log(add(1));
//returns the value of cb with add:
console.log(cb(3, 3, add));
//returns the value of with sub:
console.log(cb(4, 3, sub));
//cb only takes in values, not an entire function:
console.log(cb(3, 3, add()));
//it will print out the value of cb, and since we did not specify that it needs to
//to be numbers, it will concat the two values as a string:
console.log(cb(3, "hh", add));
/*
    More Callbacks 
    Take another look at the function expression declared in cb, and the provided 
    callbacks in 5+6. What we have in cb is a very generic function, that can 
    take any callback that can do something with two numbers and return a value.
    
    4)  Write a mul(n1, n2) function (inspired by add and sub) and use it as the 
    callback for the cb function.
*/

function mul(n1, n2) {
    return n1 * n2;
}

console.log(cb(3, 3, mul));
/*
    5) Call cb, this time with an anonymous function that divides the first
    argument with the second
*/
console.log(cb(5, 2, function (n1, n2) {
    return n1 / n2;
}));