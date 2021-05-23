package com.salesianostriana.dam.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.model.Reserva;

/**
 * Esta clase es la clase repositorio de reserva.
 * @author Daniel de Luna Rodríguez
 *
 */
public interface ReservaRepositorio 
				extends JpaRepository<Reserva,Long> {
	
	/**
	 * Consulta que se hace sobre las reservas.
	 * @param nombre Nombre de la reserva,según este se filtrarán las reservas.
	 * @return Devuelve las reservas filtradas según su nombre asociado.
	 */
	List<Reserva> findByNombreContainsIgnoreCaseOrderByNombreAsc(String nombre);

}
