package com.salesianostriana.dam.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.model.Evento;

/**
 * Clase repositorio de Evento.
 * @author Daniel de Luna Rodríguez
 *
 */
public interface EventoRepositorio 
				extends JpaRepository<Evento,Long> {

	/**
	 * Consulta que filtra por fecha los eventos.
	 * @param f1 Fecha de inicio, en este caso del mes.
	 * @param f2 Fecha de fin, en este caso del mes.
	 * @return Devuelve los eventos de un mes.
	 */
	List<Evento> findByFechaEventoBetween(LocalDate f1, LocalDate f2);
	
	/**
	 * Consulta que filtra los eventos por nombre.
	 * @param nombre Nombre del evento según el cual se va a filtrar.
	 * @return Devuelve los eventos filtrados por mes.
	 */
	List<Evento> findByNombreContainsIgnoreCaseOrderByNombreAsc(String nombre);

}
