package com.salesianostriana.dam.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.model.Reserva;
import com.salesianostriana.dam.repositorios.ReservaRepositorio;
import com.salesianostriana.dam.servicios.base.BaseService;

/**
 * Esta es la clase servicio de Reserva.
 * @author Daniel de Luna Rodríguez
 *
 */
@Service
public class ReservaService extends BaseService<Reserva,Long,ReservaRepositorio> {
	/**
	 * Envoltorio para ReservaRepositorio.
	 * @param repo Repositorio de reserva.
	 */
	public ReservaService(ReservaRepositorio repo) {
		super(repo);
	}
	/**
	 * Método para filtrar las reservas según un nombre introducido por el usuario.
	 * @param nombre Nombre según el cual se va a filtrar.
	 * @return devuelve una lista de reservas filtrada.
	 */
	public List<Reserva> reservasPorNombre(String nombre){
		return this.repos.findByNombreContainsIgnoreCaseOrderByNombreAsc(nombre);
	}
}
