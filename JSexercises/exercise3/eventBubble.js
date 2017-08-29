/**
 * a) Add a click handler to each id and write code, 
 * so when clicked, each div will write to the console 
 * "Hi from idOfTheDiv".
 */

/*
function clickHandler() {    
   console.log("Hi from " + event.target.id);
}

document.getElementById("div1").addEventListener("click", clickHandler, false);
document.getElementById("div2").addEventListener("click", clickHandler, false);
*/

/**
 * b)  Now, using cut and paste, add 10 more divs 
 * (still each with a unique id).
 * Adding an eventhandler to each div, would be 
 * cumbersome and non-efficient (what it you had 
 * been asked to add 100 or thousands of new id’s).
 * 
 * We will use JavaScript's event bubbling mechanism 
 * to solve this with only a single event handler.
 * 
 * Add a new div (without the myDiv class) with 
 * the id="outher" around all our div’s and assign 
 * a single event handler (with the event argument)
 * to this div.
 * 
 * Implement code to write to the console:
 * The value of id pointed to by this.
 * The value of id pointed to by the target propert,
 * which you get from the event argument.
 * 
 * Make SURE you understand what happened here.
 *  
 * The this.id refers to outer because the handler 
 * is run from there.
 * The eventlistener "catches" all onclick.
 * The event.target.id is the id of the actual 
 * element that was clicked and started the call.
 * So it bubbles up.
 */

/*
function clickHandler() {
    console.log("this: " + this.id);
    console.log("target property id: " + event.target.id);
}

document.getElementById("outer").addEventListener("click", clickHandler);
*/


/**
 * 3) Add an empty paragraph tag, with an id, 
 * to your HTML and change the code for both 
 * exercises above, so that output is not 
 * written to the console, but into this 
 * paragraph.
 * 
 * Hint: Use the innerText property of an 
 * Element
 */

function clickHandler() {
    var str = "this.id: " + this.id + ". " + "target property id: " + event.target.id;
    document.getElementById("logger").innerHTML = str;

}

document.getElementById("outer").addEventListener("click", clickHandler)





