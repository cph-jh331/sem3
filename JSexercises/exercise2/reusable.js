/*
    1) Implement and test the Closure Counter Example 
    from the Slides.
*/

var makeCounter = function () {
    var privateCounter = 0;
    function changeBy(val) {
        privateCounter += val;
    }
    return {
        increment: function () { changeBy(1); },
        decrement: function () { changeBy(-1); },
        value: function () { return privateCounter; }
    }
};
var counter1 = makeCounter();
var counter2 = makeCounter();


console.log(counter1.value());
counter1.decrement();
console.log(counter1.value());

console.log("*****************")

console.log(counter2.value());
counter2.increment();
console.log(counter2.value());

/*
    Implement a reusable function using the Module pattern that 
    should encapsulate information about a person (name, and age) 
    and returns an object with the following methods:
    ---setAge
    ---setName
    ---getInfo (should return a string like Peter, 45)
*/

function Person() {
    this.name;
    this.age;
}

Person.prototype.setName = function (name) {
    this.name = name;
}

Person.prototype.setAge = function (age) {
    this.age = age;
}

Person.prototype.getInfo = function () {
    return this.name + " is " + this.age + " years old.";
}

var bob = new Person();
var knud = new Person();
console.log(bob.getInfo());
console.log(knud.getInfo());
bob.setName("bobby");
knud.setName("knud");
console.log(bob.getInfo());
console.log(knud.getInfo());
bob.setAge(40);
knud.setAge(99);
console.log(bob.getInfo());
console.log(knud.getInfo());
