package com.salesianostriana.dam.servicios;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.model.Evento;
import com.salesianostriana.dam.repositorios.EventoRepositorio;
import com.salesianostriana.dam.servicios.base.BaseService;

/**
 * Clase servicio de Evento.
 * @author Daniel de Luna Rodríguez
 *
 */
@Service
public class EventoService extends BaseService<Evento,Long,EventoRepositorio>{
	/**
	 * Envoltorio para EventoRepositorio.
	 * @param repo Respositorio de EventoRepositorio.
	 */
	public EventoService(EventoRepositorio repo) {
		super(repo);
	}
	
	/**
	 * Método usado para filtrar lo eventos por mes.
	 * @param mes Mes del cual queremos el evento.
	 * @param anio Año del cial queremos el evento.
	 * @return Devuelve los eventos de un mes.
	 */
	public List<Evento> eventosDeUnMes(int mes, int anio) {
		

		LocalDate inicio = LocalDate.of(anio, mes, 1);
		LocalDate fin = inicio.with(TemporalAdjusters.lastDayOfMonth());
		
		return this.repos.findByFechaEventoBetween(inicio, fin);
		
	}
	
	/**
	 * Este método filtra los eventos por nombre.
	 * @param nombre Nombre según el cual queremos filtrar.
	 * @return Devuelve una lista de eventos filtrados.
	 */
	public List<Evento> eventosPorNombre(String nombre){
		return this.repos.findByNombreContainsIgnoreCaseOrderByNombreAsc(nombre);
	}
	
	
}
