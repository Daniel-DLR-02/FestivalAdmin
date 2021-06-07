
function contarElementosTabla(){
   
    let contadorFilas = document.getElementById("numeroFilas");

    let numeroFilas = document.querySelectorAll('table tr').length-2;
    
    contadorFilas.innerHTML=numeroFilas;
}

function validarNombreApellido(){

}

function validarNumeroTelefono(){
   
    let numeroTelefono=document.getElementById('numTelefono').value;

    alert(numeroTelefono);

    if(numeroTelefono.length!=9)
        alert("Error.")
}