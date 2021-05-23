package com.salesianostriana.dam.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.model.Evento;
import com.salesianostriana.dam.servicios.EventoService;

import lombok.RequiredArgsConstructor;

/**
 * Esta es la clase controlador del objeto evento.
 * Se encarga de pasar los eventos de manera correcta a la plantilla,
 * para así mostrarlos de manera adecuada. 
 * @author Daniel de Luna Rodríguez
 *
 */
@Controller
@RequiredArgsConstructor
public class EventoController {
	
	private final EventoService eventService;
	
	/**
	 * Este método se encarga de devolver 12 listas correspondiendo cada
	 * una a un mes del año.Estas listas almacenan los eventos correspondientes
	 * a cada mes.
	 * @param model Parámetro encargado de devolver datos.
	 * @return Como devolución tenemos la plantilla index, habiendole pasado todos los eventos.
	 */
	@GetMapping("/")
	public String indexEvents(Model model) {
		model.addAttribute("eventosEnero",eventService.eventosDeUnMes(1, 2021));
		model.addAttribute("eventosFebrero",eventService.eventosDeUnMes(2, 2021));
		model.addAttribute("eventosMarzo",eventService.eventosDeUnMes(3, 2021));
		model.addAttribute("eventosAbril",eventService.eventosDeUnMes(4, 2021));
		model.addAttribute("eventosMayo",eventService.eventosDeUnMes(5, 2021));
		model.addAttribute("eventosJunio",eventService.eventosDeUnMes(6, 2021));
		model.addAttribute("eventosJulio",eventService.eventosDeUnMes(7, 2021));
		model.addAttribute("eventosAgosto",eventService.eventosDeUnMes(8, 2021));
		model.addAttribute("eventosSeptiembre",eventService.eventosDeUnMes(9, 2021));
		model.addAttribute("eventosOctubre",eventService.eventosDeUnMes(10, 2021));
		model.addAttribute("eventosNoviembre",eventService.eventosDeUnMes(11, 2021));
		model.addAttribute("eventosDiciembre",eventService.eventosDeUnMes(12, 2021));
		return "index";	
	}
	/**
	 * Esta clase se encarga de filtrar los eventos con un 
	 * buscador.
	 * @param model Parámetro encargado de devolver datos.
	 * @param Esta consulta es la consulta introducida por el susuario.
	 * @return Como devolución tenemos la plantilla admin_evento con los eventos filtrados según su nombre.
	 */
	@GetMapping("/eventos")
	public String listarReservas(Model model, 
			@RequestParam("q") Optional<String> consulta) {
	
		if(consulta.isEmpty()) 
			model.addAttribute("eventos",eventService.findAll());
		else
			model.addAttribute("eventos",eventService.eventosPorNombre(consulta.get()));
		
		return "admin_evento";
	}
	/**
	 * Esta clase se encarga de mostrar los detalles de un evento.
	 * @param id Este es un parametro pasado por el path,que detalla cual es el evento que queremos ver.
	 * @param model Parámetro encargado de devolver datos.
	 * @return Como devolución tenemosla vista de detalles del evento,con el evento en el que hayamos seleccionado.
	 */
	@GetMapping("detalles/{id}")
	public String mostrarDetallesEvento(@PathVariable("id") long id,Model model) {
		model.addAttribute("evento",eventService.findById(id));
		model.addAttribute("reservasEvento",eventService.findById(id).getReservas());
		return "detalles";
		
	}
	/**
	 * Esta clase se encarga de mostrar el formulario de registro para un nuevo evento.
	 * @param model Parámetro encargado de devolver datos.
	 * @return Devuelve el formulario de registro de evento.
	 */
	@GetMapping("/evento/new")
	public String mostrarFormulario(Model model) {
		model.addAttribute("evento", new Evento());
		return "formEvento";
	}
	
	/**
	 * Esta clase se encarga de procesar el formulario de registro,
	 * añadiendo así el nuevo evento a la base de datos.
	 * @param evento Este parametro es el evento que vamos a introducir en la base de datos.
	 * @return Como devolución,vuelve al índice.
	 */
	@PostMapping("evento/add")
	public String addEvento(@ModelAttribute("evento") Evento evento) {
		eventService.save(evento);
		return "redirect:/";
	}
	/**
	 * Este método se encarga de abrir el formulario de edición de evento.
	 * @param id Este es el id del evento a editar.
	 * @param model Parámetro encargado de devolver datos.
	 * @return Como devolución,al terminar lleva al indice.
	 */
	@GetMapping("evento/editar/{id}")
	public String editarForm(@PathVariable("id") long id, Model model) {
		Evento eventoAEditar= eventService.findById(id);
		if (eventoAEditar != null) {
			eventoAEditar.setIdEvento(id);
			model.addAttribute("evento",eventoAEditar);
			return "formEvento";
		} else {
			return "redirect:/";
		}
	}
	
	/**
	 * Este método se encarga de borrar un evento de la base de datos.
	 * @param id Este parametro es el id del evento a borrar.
	 * @param model Parámetro encargado de devolver datos.
	 * @return Como devolución,nos devuelve a la misma plantilla de admin_evento.
	 */
	@GetMapping("evento/borrar/{id}")
	public String borrarEvento(@PathVariable("id") Long id, Model model) {
		Evento eventABorrar = eventService.findById(id);
		if (eventABorrar != null) 
			eventService.delete(eventABorrar);
	    else 
	    	return "redirect:/?error=true";
	    
		return "redirect:/eventos";
	}
	
	
	
}
