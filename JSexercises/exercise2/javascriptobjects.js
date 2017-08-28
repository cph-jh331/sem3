//everything is objects... 

var bob = { name: "bob", birthday: "0108", hobby: "eating", email: "bob@bob.dk" };

for (prop in bob) {
    console.log(prop, bob[prop]);
};

console.log("*****deleting birthday prop******")
delete bob.birthday;

for (prop in bob) {
    console.log(prop, bob[prop]);
};

bob.kills = 10;

console.log("******added kills********");
for (prop in bob) {
    console.log(prop, bob[prop]);
};

/*
    Everything is an object. Everything gets a prototype.
    When you new a Person, its gets a references to the
    Person.prototype.
*/

function Person(firstName, lastName, age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
}

/*
    If you need to call this function, you need to remember
    the (), else it will just return the actual function and
    not the return value.        
*/
Person.prototype.getInfo = function () {
    return this.age + " " + this.lastName + " " + this.firstName;
}

var jens = new Person("Jens", "Jensen", 98);
var knud = new Person("Knud", "Knudsen", 38);

console.log(jens.getInfo());
console.log(knud.getInfo());
