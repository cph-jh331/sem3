/*
    Callbacks (with map, filter and forEach)
    We saw a simple example of a callback above. 
    Let's get familiar with callbacks, using some 
    of the array-type’s built in methods. Getting 
    comfortable with filter, map and forEach.
    
    1) Declare a JavaScript array and initialize 
    it with some names:
    (Lars, Jan, Peter, Bo, Frederik etc.). 
    Use the filter method to create a new array 
    with only names of length <=3.
    Use the forEach method to iterate and print 
    (console.log) both the original and the new array.
*/

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

/*
    2) Use the names-array created above, and, 
    using its map method, create a new array 
    with all names uppercased.
*/
var nameCaps = namesLessThan4.map(function (name) {
    return name.toLocaleLowerCase();
});

nameCaps.forEach(function (element) {
    console.log(element);
});

/*
    3) Use map, join + just a little bit more to create 
    a function, which given the array of names, for 
    example: ["Lars", "Peter", "Jan", "Ian"] returns 
    a string with the HTML for the names in a <ul>
*/

function ulGenerator(nameArray) {
    // we use map to add <li> </li> to the new array.
    var newArray = nameArray.map(function (name) {
        return "<li>" + name + "</li>";
    });
    //then we return the string.
    return "<ul>" + newArray.join('') + "</ul>";
};
console.log("*********************");
console.log(ulGenerator(names));

/*
    4)  Given this JavaScript array:
*/

var cars = [
    { id: 1, year: 1997, make: 'Ford', model: 'E350', price: 3000 },
    { id: 2, year: 1999, make: 'Chevy', model: 'Venture', price: 4900 },
    { id: 3, year: 2000, make: 'Chevy', model: 'Venture', price: 5000 },
    { id: 4, year: 1996, make: 'Jeep', model: 'Grand Cherokee', price: 4799 },
    { id: 5, year: 2005, make: 'Volvo', model: 'V70', price: 44799 }
];

/*
    a) Use the filter filter function to get arrays with only:
    -Cars newer than 1999:    
*/
var newer1999 = cars.filter(function (element) {
    return element.year > 1999;
});
console.log("Cars from after 1999");
console.log(newer1999);

/*
    -Al  Volvo’s.    
*/
var volvos = cars.filter(function (element) {
    return element.make.toLocaleLowerCase === "volvo";
});
console.log("Volvo cars");
console.log(volvos);

/*
    -All cars with a price below 5000.
*/
var below5000 = cars.filter(function (element) {
    return element.price < 5000;
});
console.log("below 5000");
console.log(below5000);

/*
    -Can you refactor this into three methods, that takes the 
    filter text as argument.
*/
function carsAfterYear(year) {
    return cars.filter(function (element) {
        return element.year > year;
    });
};

console.log("cars after year");
console.log(carsAfterYear(1999));

function carsWithBrand(brandName) {
    return cars.filter(function (car) {
        return car.make.toLocaleLowerCase() === brandName.toLocaleLowerCase();
    });
};

console.log("cars with brand")
console.log(carsWithBrand("chevy"));

function cheaperThan(price) {
    return cars.filter(function (car) {
        return car.price < price;
    });
};

console.log("cars cheaper than")
console.log(cheaperThan(4000));

/*
    -Can you refactor this into one method, that takes the 
    filter text, and type,  as argument
*/
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

/*
    switch version:
*/
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

/*
    4a) Use map, join + just a little bit more to, 
    given the cars array used above, will create 
    valid SQL statements to insert the data into 
    a table with matching column names 
    (id,year, make, model, price):
*/

console.log("******4a*******");
function insertIntoGen(carArray) {
    return carArray.map(function (car) {
        return "INSERT INTO cars (id,year,make,model,price) VALUES ( "
            + car.id + ", " + car.year + ", '" + car.make + "','"
            + car.model + "'," + car.price + " )";
    }).join(';');
}
console.log(insertIntoGen(cars));

/*
    4b) Combine (using chaining) 4 + 4a to create the SQL, 
    only for the conditions given in 4.
*/

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