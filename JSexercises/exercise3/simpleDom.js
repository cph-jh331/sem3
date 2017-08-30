function setTheColor() {
    var color = 'pink';
    var divs = document.getElementsByTagName("div");
    for (var index = 0; index < divs.length; index++) {
        divs[index].style.backgroundColor = color;
    }
}

function clickChangeColor() {

    document.getElementById("div1").style.backgroundColor = "orange";
    document.getElementById("div2").style.backgroundColor = "blue";
    document.getElementById("div3").style.backgroundColor = "teal";
}

document.getElementById("btn").onclick = clickChangeColor;