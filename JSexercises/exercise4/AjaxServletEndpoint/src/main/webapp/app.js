/*
 * {
 "year": 2017,
 "month": 7,
 "dayOfMonth": 31,
 "hourOfDay": 14,
 "minute": 29,
 "second": 24
 }
 */

var interval;
/*
 * If you want the calander object:
function getTime() {
    var promise = fetch('TimeServlet');
    promise.then(function (response) {
        return response.json();//Why return here?
    }).then(function (calender) {
        var str = calender.hourOfDay + ":" + calender.minute + ":" + calender.second;
        document.getElementById("time").innerText = str;
    });
}
*/

/*
 * If you want a string with the time, this fixes the missing 0 on seconds:
 */
function getTime() {
    var promise = fetch('TimeServlet');
    promise.then(function (response) {
        return response.json();//Why return here?
    }).then(function (dateString) {        
        document.getElementById("time").innerText = dateString;
    });
}


function startGetTime() {
    interval = setInterval(getTime, 1000);    
}


