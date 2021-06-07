
function contarElementosTabla(){
   
    let contadorFilas = document.getElementById("numeroFilas");

    let numeroFilas = document.querySelectorAll('table tr').length-2;
    
    contadorFilas.innerHTML=numeroFilas;
}

function validarNombreApellido(){

}

function validarNumeroTelefono(){
   
    let campoNumeroTelefono = document.getElementById('error_numeroTelefono')
    let numeroTelefono=document.getElementById('numTelefono').value;
    let mensajeError=document.getElementById('error_numeroTelefono');

    let inputNumeroDeTelefono=document.getElementById('numTelefono');

    if((numeroTelefono.length!=9 || numeroTelefono[0]==0 || numeroTelefono[0]==1 || numeroTelefono[0]==2 
        || numeroTelefono[0]==3 || numeroTelefono[0]==4 || numeroTelefono[0]==5 || numeroTelefono[0]==0)){
        mensajeError.classList = 'formulario__input-error-activo';
        inputNumeroDeTelefono.classList = 'formulario_marco_error form-control';
    }
    else if((numeroTelefono.length==9 || numeroTelefono[0]!=0 || numeroTelefono[0]!=1 || numeroTelefono[0]!=2
        || numeroTelefono[0]!=3 || numeroTelefono[0]!=4 || numeroTelefono[0]!=5 || numeroTelefono[0]!=0)){
        mensajeError.classList = 'formulario__input-error';
        inputNumeroDeTelefono.classList = 'formulario__input form-control';
    }

        
}