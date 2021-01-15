window.addEventListener("load", function(event) {
    var ano = new Date().getFullYear();
    var text = '2020 - ' + ano + ' Fernando Matheus';
    document.getElementById("copyright").textContent = text;
});