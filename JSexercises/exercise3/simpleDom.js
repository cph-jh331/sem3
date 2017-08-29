function setColor() {
    var nodeArray = document.getElementsByTagName("div");
    var color = 'pink';
    for (node in nodeArray) {
        nodeArray[node].style.backgroundColor = color;
    }
}

function changeColor() {
    var colors = ['orange', 'blue', 'black'];
   element.getElementById("div1").style.backgroundColor = 'orange';
    element.getElementById("div2").style.backgroundColor = 'blue';
    element.getElementById("div3").style.backgroundColor = 'purple';
}

document.getElementById("btn").onclick = changeColor;