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

function Person(firstName, lastName, age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
}

var jens = new Person("Jens", "Jensen", 98);

console.log(jens);



