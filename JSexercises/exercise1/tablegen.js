var myArray = [34, 12, 95, 100, -13, 200, 99];
var lessThan90 = myArray.filter(function (number) {
    return number < 90;
});

var addhtml = myArray.map(function (number) {
    return "<tr>" + number + "</tr>";
});







