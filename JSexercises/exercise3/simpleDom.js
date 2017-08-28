function changeColor() {
    var colors = ['orange', 'blue', 'black'];
    var divVar = document.getElementsByTagName("div");
    console.log(divVar[0]);
    for (var index = 0; index < divVar.length; index++) {
        divVar[index].style.background = colors[index];        
    }
}