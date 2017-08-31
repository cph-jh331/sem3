function south() {
    document.getElementById("compass").innerText = "SOUTH";
}
function north() {
    document.getElementById("compass").innerText = "NORTH";
}
function west() {
    document.getElementById("compass").innerText = "WEST";
}
function east() {
    document.getElementById("compass").innerText = "EAST";
}

document.getElementById("south").addEventListener("click", south);
document.getElementById("east").addEventListener("click", east);
document.getElementById("west").addEventListener("click", west);
document.getElementById("north").addEventListener("click", north);


