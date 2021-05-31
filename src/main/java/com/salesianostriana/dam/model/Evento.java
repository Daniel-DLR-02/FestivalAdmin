package com.salesianostriana.dam.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Esta es la clase objeto de Evento.
 * @author Daniel de Luna Rodríguez
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Evento {

	@Id
	@GeneratedValue
	private long idEvento;
	
	private String nombre,descripcion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaEvento;
	
	private double precioEntrada;
	private String image;
	
	private String alt_img;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="evento", fetch = FetchType.EAGER)
	private List<Reserva> reservas = new ArrayList<>();
	/**
	 * Constructor de Evento.
	 * @param nombre Nombre del evento.
	 * @param descripcion Breve descripción del evento.
	 * @param fechaEvento Fecha en la cual transcurre el evento.
	 * @param precioEntrada Precio de la entrada del evento.
	 * @param image Imagen asociada al evento.
	 * @param alt_img Texto alternativo que tendrá la imagen.
	 */
	public Evento(String nombre,String descripcion,LocalDate fechaEvento,double precioEntrada,String image,String alt_img) {
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.fechaEvento=fechaEvento;
		this.precioEntrada=precioEntrada;
		this.image=image;
		this.alt_img=alt_img;
	}
	/**
	 * Esta clase se encarga de añadir una reserva de la lista de reservas asociada a un evento.
	 * @param r Este parámetro es la reserva a añadir.
	 */
	public void addReserva(Reserva r) {
		this.reservas.add(r);
		r.setEvento(this);
	}
	/**
	 * Esta clase se encarga de eliminar una reserva de la lista de reservas asociada a un evento.
	 * @param r Este parámetro es la reserva a eliminar.
	 */
	
	public void removeReserva(Reserva r) {
		this.reservas.remove(r);
		r.setEvento(null);
	}
}
