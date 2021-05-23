package com.salesianostriana.dam.servicios;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.model.Evento;
import com.salesianostriana.dam.repositorios.EventoRepositorio;
import com.salesianostriana.dam.servicios.base.BaseService;

@Service
public class EventoService extends BaseService<Evento,Long,EventoRepositorio>{
	
	public EventoService(EventoRepositorio repo) {
		super(repo);
	}
	
	
	public List<Evento> eventosDeUnMes(int mes, int anio) {
		

		LocalDate inicio = LocalDate.of(anio, mes, 1);
		LocalDate fin = inicio.with(TemporalAdjusters.lastDayOfMonth());
		
		return this.repos.findByFechaEventoBetween(inicio, fin);
		
	}
	
	public List<Evento> eventosPorNombre(String nombre){
		return this.repos.findByNombreContainsIgnoreCaseOrderByNombreAsc(nombre);
	}
	
	
}
