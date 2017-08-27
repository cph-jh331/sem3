var boys = ["Peter", "lars", "Ole"];
var girls = ["Janne", "Hanne", "Sanne"];
console.log(boys.length);

var all = boys.concat(girls);
console.log(boys);
console.log(all);

var namesjoin = all.join(',');
var namesWithHyphen = all.join('-');
console.log(namesWithHyphen);
console.log(namesjoin);

all.push('Lone', 'Gitte');
console.log(all);
all.unshift('Hans', 'Kurt');
console.log(all);

//shift() removes the first item from the array and returns it.
var firstNameInArray = all.shift();
console.log(all);
console.log(firstNameInArray);
//pop() removes the last item from the array and returns it.
var lastNameInArray = all.pop();
console.log(all);
console.log(lastNameInArray);

// 3 is the index, 2 is the number of items to remove, bob is inserted into index 3 and everything is moved. The method retuns an array with the removed items.
var removedItems = all.splice(3, 2, 'Bob');
console.log(removedItems);
console.log(all);

//reverses the current array.
all.reverse();
console.log(all);

all.sort();
console.log(all);
// everything should be oneliners according to the exercise.
// all.sort(insensitiveCompare);
// console.log(all);
// function insensitiveCompare(a,b){
//  	return a.toLowerCase().localeCompare(b.toLowerCase());
// }

all.sort(function (a, b) {
    return a.toLowerCase().localeCompare(b.toLowerCase());
});

console.log(all);

var allUpperCase = all.map(function (x) {
    return x.toUpperCase();
});

console.log(all);
console.log(allUpperCase);

//The array type has a method filter() that creates a new array with all elements that pass the test implemented by the provided callback

// m) Create a new array containing all the names that start with either “l” or “L” (hint: use the filter function with a sufficient callback). 

var namesWithL = all.filter(function (a) {
    return a.charAt(0) == 'l' || a.charAt(0) == 'L';
});

console.log(namesWithL);