
function contarElementosTabla(){
   
    let contadorFilas = document.getElementById("numeroFilas");

    let numeroFilas = document.querySelectorAll('table tr').length-2;
    
    contadorFilas.innerHTML=numeroFilas;
}

contarElementosTabla();

function validarNombre(){
    let patronNombre =/^[a-zA-Z ]{2,30}$/;

    let nombre = document.getElementById('nombre').value;  
    let mensajeError=document.getElementById('error_nombre');
    let grupoFormulario = document.getElementById("marco_input-nombre");
    if(!patronNombre.test(String(nombre).toLowerCase())){
        mensajeError.classList = 'formulario__input-error-activo';
        grupoFormulario.classList='formulario__grupo-incorrecto';
    }
    else if(patronNombre.test(String(nombre).toLowerCase())){
        mensajeError.classList = 'formulario__input-error';
        grupoFormulario.classList='formulario__grupo-input';
    }
}

function validarApellidos(){
    let patronApellidos =/^[a-zA-Z ]{2,30}$/;

    let apellidos = document.getElementById('apellidos').value;  
    let mensajeError=document.getElementById('error_apellidos');
    let grupoFormulario = document.getElementById("marco_input-apellidos");

    if(!patronApellidos.test(String(apellidos).toLowerCase())){
        mensajeError.classList = 'formulario__input-error-activo';
        grupoFormulario.classList='formulario__grupo-incorrecto';
    }
    else if(patronApellidos.test(String(apellidos).toLowerCase())){
        mensajeError.classList = 'formulario__input-error';
        grupoFormulario.classList='formulario__grupo-input';
    }
}

function validarNumeroTelefono(){
   
    let numeroTelefono=document.getElementById('numTelefono').value;
    for(let i=0;i<numeroTelefono.length;i++)
        numeroTelefono = numeroTelefono.replace(" ","");
    numeroTelefono=parseInt(numeroTelefono);
    let mensajeError=document.getElementById('error_numeroTelefono');
    let grupoFormulario = document.getElementById("marco_input-telefono");

    if(numeroTelefono<=600000000 || numeroTelefono >= 999999999 || Number.isNaN(numeroTelefono)){
        mensajeError.classList = 'formulario__input-error-activo';
        grupoFormulario.classList='formulario__grupo-incorrecto';
    }
    else if(numeroTelefono>=600000000 && numeroTelefono <= 999999999){
        mensajeError.classList = 'formulario__input-error';
        grupoFormulario.classList='formulario__grupo-input';
    }

        
}

function validarCorreoElectronico(){

    let email = document.getElementById('correoElectronico').value;  

    let mensajeError=document.getElementById('error_correoElectronico');
    let grupoFormulario = document.getElementById("marco_input-correoElectronico");

    let patronCorreo = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (!patronCorreo.test(String(email).toLowerCase())){
        mensajeError.classList = 'formulario__input-error-activo';
        grupoFormulario.classList='formulario__grupo-incorrecto';
    }
    else if (patronCorreo.test(String(email).toLowerCase())){
        mensajeError.classList = 'formulario__input-error';
        grupoFormulario.classList='formulario__grupo-input';
    }
}

function validarPrecioEntrada(){
    let patronAEvitar =/^[0-9]+([.][0-9]+)?$/;  

    let precio = document.getElementById('precioEntrada').value;  

    let mensajeError=document.getElementById('error_precioEntrada');
    let grupoFormulario = document.getElementById("marco_input-precioEntrada");

    if(!patronAEvitar.test(String(precio).toLowerCase())){
        mensajeError.classList = 'formulario__input-error-activo';
        grupoFormulario.classList='formulario__grupo-incorrecto';
    }


}

function validarDescripcion(){
    
    let descripcion = document.getElementById('descripcion').value;

    let mensajeError=document.getElementById('error_descripcion');
    let grupoFormulario = document.getElementById("marco_input-descripcion");

    alert(descripcion);
    if(descripcion.length>255){
        mensajeError.classList = 'formulario__input-error-activo';
        grupoFormulario.classList='formulario__grupo-incorrecto';
    }
}