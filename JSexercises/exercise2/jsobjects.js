/**
 * JavaScript Objects
 * 1) Create an object with four different properties, 
 * with values, of your own choice 
 * (ex: name, birthday, hobby, email).
 * 
 * Use a for-in loop (as sketched below) to demonstrate
 * that we can iterate over the properties in an object.
 */

var bob = { name: "Bob", birthday: "1999-11-01", hobby: "Eating", email: "bob@bob.dk" };

for (property in bob) {
    console.log(property, bob[property]);
}

/**
 * Use the delete keyword to demonstrate we can delete 
 * existing properties from an object (delete a property, 
 * and iterate over the properties again) 
 */
delete bob.birthday;

for (property in bob) {
    console.log(property, bob[property]);
}

/**
 * Add a new property to your object to demonstrate 
 * that we can add new properties to existing objects.
 */
bob.kills = 20;

for (property in bob) {
    console.log(property, bob[property]);
}

/**
 * 2) Create a Constructor function to create new Persons having:
 * a firstName, lastName and an age.
 * A method to get details about the Person
 * 
 * Everything is an object. Everything gets a prototype.
 * When you new a Person, it gets a references to the
 * Person.prototype. A new person has a __proto__ which is
 * equal to the Person.prototype.
 */

function Person(firstName, lastName, age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
}

Person.prototype.getInfo = function () {
    return this.age + " " + this.lastName + " " + this.firstName;
}

var tod = new Person("Todd", "Toddsen", 54);
console.log(tod.getInfo());