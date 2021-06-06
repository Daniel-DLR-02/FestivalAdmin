
function contarElementosTabla(){
   
    let contadorFilas = document.getElementById("numeroFilas");

    let numeroFilas = $('table tr').length-2;
    
    contadorFilas.innerHTML=numeroFilas;
    return numeroFilas;
}

contarElementosTabla();