function add(n1, n2) {
    return n1 + n2;
}

var sub = function (n1, n2) {
    return n1 - n2;
};

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

//this should return 3:
console.log(add(1, 2));
//Wasn't sure what it would return, but it returns the function as typed:
console.log(add);
//Returns the sum of 1+2 and ignores the last parameter. Does not throw and error:
console.log(add(1, 2, 3));
//Returns as a NaN value, because you trying to add to an non existent element:
console.log(add(1));
//f1 is not defined, browser does not know wtf you are talking about, so changed it
//to cb. 
//returns the value of cb with add:
console.log(cb(3, 3, add));
//returns the value of with sub:
console.log(cb(4, 3, sub)); // What will it print
//cb only takes in values, not an entire function:
console.log(cb(3, 3, add())); // What will it print (and what was the problem)
//it will print out the value of cb, and since we did not specify that it needs to
//to be numbers, it will concat the two values as a string:
console.log(cb(3, "hh", add));// What will it print

//More Callbacks 
//Take another look at the function expression declared in cb, and the provided 
//callbacks in 5+6. What we have in cb is a very generic function, that can 
//take any callback that can do something with two numbers and return a value.
//
//4)  Write a mul(n1, n2) function (inspired by add and sub) and use it as the 
//callback for the cb function
//
//5) Call cb, this time with an anonymous function that divides the first 
//argument with the second

function mul(n1, n2) {
    return n1 * n2;
}

console.log(cb(3, 3, mul));

console.log(cb(5, 2, function (n1, n2) {
    return n1 / n2;
}));

console.log("Getting confortable with filter and forEach");

var names = ["Lars", "Jan", "Peter", "Bo", "Frederik", "Bob"];

var namesLessThan4 = names.filter(function (name) {
    return name.length <= 3;
});

names.forEach(function (element) {
    console.log(element);
});

namesLessThan4.forEach(function (element) {
    console.log(element);
});

var nameCaps = namesLessThan4.map(function (name) {
    return name.toUpperCase();
});

nameCaps.forEach(function (element) {
    console.log(element);
});

function ulGenerator(nameArray) {
    // we use map to add <li> </li> to the new array.
    var newArray = nameArray.map(function (name) {
        return "<li>" + name + "</li>";
    });
    //we splice it the new array, so the first value is <ul>
    newArray.splice(0, 0, "<ul>");
    //we splice it again, but this time add </ul> to the array.
    newArray.splice(newArray.length, 0, "</ul>");
    //then we return the string.
    return newArray.join('');
    //I cannot figure out how to make this a single line, and why
    //you should do it.
};
console.log("*********************");
console.log(ulGenerator(names));

console.log("*****Part 4:******");
//Use the filter filter function to get arrays with only:
//Cars newer than 1999
//Al  Volvo’s
//All cars with a price below 5000
//Can you refactor this into three methods, that takes the filter text as argument
//Can you refactor this into one method, that takes the filter text, and type,  as argument
var cars = [
    { id: 1, year: 1997, make: 'Ford', model: 'E350', price: 3000 },
    { id: 2, year: 1999, make: 'Chevy', model: 'Venture', price: 4900 },
    { id: 3, year: 2000, make: 'Chevy', model: 'Venture', price: 5000 },
    { id: 4, year: 1996, make: 'Jeep', model: 'Grand Cherokee', price: 4799 },
    { id: 5, year: 2005, make: 'Volvo', model: 'V70', price: 44799 }
];

console.log(cars);

var newer1999 = cars.filter(function (element) {
    return element.year > 1999;
});
console.log("Cars from after 1999");
console.log(newer1999);

var volvos = cars.filter(function (element) {
    return element.make.toLocaleLowerCase === "volvo";
});
console.log("Volvo cars");
console.log(volvos);

var below5000 = cars.filter(function (element) {
    return element.price < 5000;
});
console.log("below 5000");
console.log(below5000);

//Can you refactor this into three methods, that takes the filter text as argument

// If we have the variable in this script, we can do this, else we would need an extra parameter:
function greaterThanYearCars(year) {
    return cars.filter(function (element) {
        return element.year > year;
    });
};

console.log(greaterThanYearCars(1999));

function carsWithBrand(brandName) {
    return cars.filter(function (car) {
        return car.make.toLocaleLowerCase() === brandName.toLocaleLowerCase();
    });
};

console.log(carsWithBrand("chevy"));

function cheaperThan(price) {
    return cars.filter(function (car) {
        return car.price < price;
    });
};

console.log(cheaperThan(4000));

//Can you refactor this into one method, that takes the filter text, and type, as argument
//Can this be done in a single line?
function threeInOne(whatToFind, theValue) {
    if (whatToFind.toLocaleLowerCase() === "cars after year") {
        return cars.filter(function (car) {
            return car.year > theValue;
        });
    } else if (whatToFind.toLocaleLowerCase() === "cars with brand") {
        return cars.filter(function (car) {
            return car.make.toLocaleLowerCase() === theValue.toLocaleLowerCase();
        });
    } else if (whatToFind.toLocaleLowerCase() === "cars cheaper than") {
        return cars.filter(function (car) {
            return car.price < theValue;
        });
    }
};

function switchThreeInOne(whatToFind, theValue) {
    switch (whatToFind.toLocaleLowerCase()) {
        case "cars after year":
            return cars.filter(function (car) {
                return car.year > theValue;
            });
        case "cars with brand":
            return cars.filter(function (car) {
                return car.make.toLocaleLowerCase() === theValue.toLocaleLowerCase();
            });
        case "cars cheaper than":
            return cars.filter(function (car) {
                return car.price < theValue;
            });
        default:
            throw new Error("what to find value is invalid.");
    };
};

console.log("****threeInOne*****");
console.log("cars after year 1996")
console.log(threeInOne("cars after year", 1996));
console.log("cars with brand chevy");
console.log(threeInOne("cars with brand", "chevy"));
console.log("cars cheaper than 4000");
console.log(threeInOne("cars cheaper than", 4000));

//Use map, join + just a little bit more to, given 
//the cars array used above, will create valid SQL 
//statements to insert the data into a table with 
//matching column names (id,year, make, model, price)
//as sketched below:

console.log("******4a*******");

function insertIntoGen(carArray) {

    return carArray.map(function (car) {
        return "INSERT INTO cars (id,year,make,model,price) VALUES ( "
            + car.id + ", " + car.year + ", '" + car.make + "','"
            + car.model + "'," + car.price + " )";
    }).join(';');
}

console.log("****insert every car****");
console.log(insertIntoGen(cars));

//Combine (using chaining) 4 + 4a to create the SQL, 
//only for the conditions given in 4... what is a prototype and how do you use it.
console.log("***********4b************");

cars.getSpecificCars = function (whatToFind, theValue) {
    switch (whatToFind.toLocaleLowerCase()) {
        case "cars after year":
            return cars.filter(function (car) {
                return car.year > theValue;
            });
        case "cars with brand":
            return cars.filter(function (car) {
                return car.make.toLocaleLowerCase() === theValue.toLocaleLowerCase();
            });
        case "cars cheaper than":
            return cars.filter(function (car) {
                return car.price < theValue;
            });
        default:
            throw new Error("something was invalid.");
    };
};

cars.getInsertSqlForSpecificCars = function (whatToFind, theValue) {
    return cars.getSpecificCars(whatToFind, theValue).map(function (car) {
        return "INSERT INTO cars (id,year,make,model,price) VALUES ("
            + car.id + "," + car.year + ",'" + car.make + "','"
            + car.model + "'," + car.price + ");";
    }).join('');
};

console.log(cars.getSpecificCars("cars with brand", "chevy"));
console.log(cars.getInsertSqlForSpecificCars("cars with brand", "chevy"));

/*
Asynchronous Callbacks
    Most of the javascript callbacks you will be using, will be asynchronous, 
    in contrary to map, filter and forEach which are synchronous (MAKE SURE 
    you understand the difference)
    1) Given the code below answer, don’t execute the code, in what order 
    you would expect to see the outputs:
*/
/*
var msgPrinter = function (msg, delay) {
    setTimeout(function () {
        console.log(msg);
    }, delay);
};
console.log("aaaaaaaaaa");

//1000 = 1 sec.
msgPrinter("bbbbbbbbbb", 2000);
console.log("dddddddddd");
msgPrinter("eeeeeeeeee", 1000);
console.log("ffffffffff");
*/
/*
this and constructor functions 
    The value of this, passed to all functions, is based on the context 
    in which the function is called at runtime. Pay attention here, 
    because this is one of those quirks you just need to memorize.

    In the example below we actually have two versions of this in 
    play (one for the outer function, and one for the asynchronous callback)
*/

console.log("******This and Constructor funcs***********");

/* function Person(name) {
    this.name = name;
    console.log("Name: " + this.name);
    setTimeout(function () {
        console.log("Hi  " + this.name);  //Explain this
        // my debug console says it is undefined... chrome can figure it out though.  

    }, 2000);
}
//call it like this (do it, even if you know it’s silly ;-)
Person("Kurt Wonnegut");  //This calls the function
console.log("I'm global: " + name);  //Explain this

var p = Person("BOBBY");
console.log("Hi " + name); */


function Person(name) {
    this.name = name;
    var self = this;
    console.log("Name: " + this.name);
    setTimeout(function () {
        console.log("Hi  " + self.name);
    }, 2000);
}

function Person(name) {
    this.name = name;
    console.log("Name: " + this.name);
    setTimeout(function () {
        console.log("Hi asd " + this.name);
    }.bind(this), 2000);
}


var p = Person("BOBBY");
console.log("Hi " + name);

var greeter = function () {
    console.log(this.message);
};
var comp1 = { message: "Hello World" };
var comp2 = { message: "Hi" };

var g1 = greeter.bind(comp1);//We can store a reference, with a specific “this” to use
var g2 = greeter.bind(comp2);//And here another “this”
setTimeout(g1, 3000);
setTimeout(g2, 4000);





