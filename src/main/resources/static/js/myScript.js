
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
    for(let i=0;i<numeroTelefono.length;i++)
        numeroTelefono = numeroTelefono.replace(" ","");
    let mensajeError=document.getElementById('error_numeroTelefono');
    let inputNumeroDeTelefono=document.getElementById('numTelefono');
    let grupoFormulario = document.getElementById("marco_input-telefono");

    if(numeroTelefono.length!=9 || numeroTelefono[0]==0 || numeroTelefono[0]==1 || numeroTelefono[0]==2 
        || numeroTelefono[0]==3 || numeroTelefono[0]==4 || numeroTelefono[0]==5){
        mensajeError.classList = 'formulario__input-error-activo';
        grupoFormulario.classList='formulario__grupo-incorrecto';
    }
    else if(numeroTelefono.length==9 || numeroTelefono[0]!=0 || numeroTelefono[0]!=1 || numeroTelefono[0]!=2
        || numeroTelefono[0]!=3 || numeroTelefono[0]!=4 || numeroTelefono[0]!=5 ){
        mensajeError.classList = 'formulario__input-error';
        grupoFormulario.classList='formulario__grupo-input'
    }

        
}

function validarCorreoElectronico(){
    
}