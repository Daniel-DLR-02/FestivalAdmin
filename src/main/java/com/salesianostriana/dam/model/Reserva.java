package com.salesianostriana.dam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	 
	 public Reserva(String nombre,String apellidos,String numTelefono,String correoElectronico,Evento evento) {
		 this.nombre=nombre;
		 this.apellidos=apellidos;
		 this.numTelefono=numTelefono;
		 this.correoElectronico=correoElectronico;
		 this.evento=evento;
	 }
	 
}
