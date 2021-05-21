package com.salesianostriana.dam.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.model.Evento;

public interface EventoRepositorio 
				extends JpaRepository<Evento,Long> {

	
	List<Evento> findByFechaEventoBetween(LocalDate f1, LocalDate f2);
	
}
