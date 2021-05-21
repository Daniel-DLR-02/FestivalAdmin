package com.salesianostriana.dam.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.model.Reserva;

public interface ReservaRepositorio 
				extends JpaRepository<Reserva,Long> {
	
	List<Reserva> findByNombreContainsIgnoreCaseOrderByNombreAsc(String nombre);

}
