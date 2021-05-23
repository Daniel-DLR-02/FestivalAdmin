package com.salesianostriana.dam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta es la clase objeto de Reserva.
 * @author Daniel de Luna Rodríguez
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reserva {
	
	@Id
	@GeneratedValue
	private long idReserva;
	
	private String nombre,apellidos,numTelefono,correoElectronico;
	
	 @ManyToOne
	 private Evento evento;
	 /**
	  *	Cosnstructor de. 
	  * @param nombre Nombre asociado a la reserva.
	  * @param apellidos Apellidos asociados a la reserva.
	  * @param numTelefono Número de teléfono asociado a la reserva.
	  * @param correoElectronico Correo electrónico asociado a la reserva.
	  * @param evento Evento asociado a la reserva.
	  */
	 public Reserva(String nombre,String apellidos,String numTelefono,String correoElectronico,Evento evento) {
		 this.nombre=nombre;
		 this.apellidos=apellidos;
		 this.numTelefono=numTelefono;
		 this.correoElectronico=correoElectronico;
		 this.evento=evento;
	 }
	 
}
