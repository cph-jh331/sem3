/*
    this and constructor functions 

    The value of this, passed to all functions, 
    is based on the context in which the function 
    is called at runtime. Pay attention here, 
    because this is one of those quirks you just 
    need to memorize.

    In the example below we actually have two versions 
    of this in play (one for the outer function, and
    one for the asynchronous callback)

    1) Add this code:
*/

/*
function Person(name) {
    this.name = name;
    console.log("Name: " + this.name);
    setTimeout(function () {
        console.log("Hi  " + this.name);  //Explain this(*a)
    }, 2000);
}
*/

/*
    *a: It delays the console log by 2sec. when you "run"
    the object, it will take 2secs before the console prints anything.
    The this.name will say undefined because, the inner function does
    not have a anything in this.name. IT DOES NOT REFER TO THE "THIS"
    IN THE OUTER FUNCTION.
*/

//call it like this (do it, even if you know it’s silly ;-))
//Person("Kurt Wonnegut");
//console.log("I'm global: "+ name);  //Explain this (*b)

/*
    *b: You did not "new" the Person, so the "this" refers to the
    global object, instead of a new Person object. This means
    that you have actually added a global property with the name
    "name" with the value of "Kurt Wonnegut".
*/

/**
 *  2) Create a Person instance an rerun the example as sketched 
 *  below: 
 */

//var p = new Person("Kurt Wonnegut");  //Create an instance using the constructor function
//console.log("I'm global: "+ name);  //What’s different (*c)

/**
 * *c: It throws an reference error, because there is no global property
 * with the name "name", since you are now correctly instantiating
 * a Person object.
*/

/**
 * 3) Change your code to fix the problem.
*/

/**
 * This fixes the problem by creating a local var 
 * in the function, which can be used in the inner 
 * function instead of the confusing "this".
 */
function Person(name) {
    this.name = name;
    var self = this;
    console.log("Name: " + this.name);
    setTimeout(function () {
        console.log("Hi  " + self.name);
    }, 2000);
}

/**
 * Here we set the inner function's "this"
 * to the Person object. Meaning that the
 * "this" in the inner function now refers
 * back to the "this" in the outher function.
 */
function Person(name) {
    this.name = name;
    console.log("Name: " + this.name);
    setTimeout(function () {
        console.log("Hi  " + this.name);
    }.bind(this), 2000);
}
/**
 * 4) The bind method will be extremely important 
 * to understand for our future journey into 
 * javascript.
 * 
 * Write, run and UNDERSTAND the example below:
 */
var greeter = function () {
    console.log(this.message);
};
var comp1 = { message: "Hello World" };
var comp2 = { message: "Hi" };

/**
 * comp1 has an inner property:
 * 
 * this.message = Hello world.
 * 
 * when we bind comp to greeter, then greeters "this" 
 * refers to comp's this.
 */
var g1 = greeter.bind(comp1);//We can store a reference, with a specific “this” to use
var g2 = greeter.bind(comp2);//And here another “this”
setTimeout(g1, 500);
setTimeout(g2, 1000);


























