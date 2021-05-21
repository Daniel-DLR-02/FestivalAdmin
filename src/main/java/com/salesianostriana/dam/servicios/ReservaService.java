package com.salesianostriana.dam.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.model.Reserva;
import com.salesianostriana.dam.repositorios.ReservaRepositorio;
import com.salesianostriana.dam.servicios.base.BaseService;

@Service
public class ReservaService extends BaseService<Reserva,Long,ReservaRepositorio> {

	public ReservaService(ReservaRepositorio repo) {
		super(repo);
	}
	
	public List<Reserva> reservasPorNombre(String nombre){
		return this.repos.findByNombreContainsIgnoreCaseOrderByNombreAsc(nombre);
	}
}
