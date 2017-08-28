/*
    Asynchronous Callbacks
    Most of the javascript callbacks you will be using, will be asynchronous, 
    in contrary to map, filter and forEach which are synchronous (MAKE SURE 
    you understand the difference)
    1) Given the code below answer, don’t execute the code, in what order 
    you would expect to see the outputs:
*/

var msgPrinter = function (msg, delay) {
    setTimeout(function () {
        console.log(msg);
    }, delay);
};

console.log("aaaaaaaaaa");//1
msgPrinter("bbbbbbbbbb", 2000);//5 2000 = 2sec.
console.log("dddddddddd");//2
msgPrinter("eeeeeeeeee", 1000);//4 1000 = 1sec.
console.log("ffffffffff");//3