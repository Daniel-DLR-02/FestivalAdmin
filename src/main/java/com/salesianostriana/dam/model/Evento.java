package com.salesianostriana.dam.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Evento {

	@Id
	@GeneratedValue
	private long idEvento;
	
	private String nombre,descripcion;
	private LocalDate fechaEvento;
	private double precioEntrada;
	private String image;
	
	public Evento(String nombre,String descripcion,LocalDate fechaEvento,double precioEntrada,String image) {
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.fechaEvento=fechaEvento;
		this.precioEntrada=precioEntrada;
		this.image=image;
	}
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="evento", fetch = FetchType.EAGER)
	private List<Reserva> reservas = new ArrayList<>();
	
	public void addAlumno(Reserva r) {
		this.reservas.add(r);
		r.setEvento(this);
	}
	
	public void removeAlumno(Reserva r) {
		this.reservas.remove(r);
		r.setEvento(null);
	}
}
