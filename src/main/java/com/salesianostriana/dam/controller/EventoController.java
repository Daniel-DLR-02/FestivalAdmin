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

@Controller
@RequiredArgsConstructor
public class EventoController {
	
	private final EventoService eventService;
	
	
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
	@GetMapping("/eventos")
	public String listarReservas(Model model, 
			@RequestParam("q") Optional<String> consulta) {
	
		if(consulta.isEmpty()) 
			model.addAttribute("eventos",eventService.findAll());
		else
			model.addAttribute("eventos",eventService.eventosPorNombre(consulta.get()));
		
		return "admin_evento";
	}
	
	@GetMapping("detalles/{id}")
	public String mostrarDetallesEvento(@PathVariable("id") long id,Model model) {
		model.addAttribute("evento",eventService.findById(id));
		model.addAttribute("reservasEvento",eventService.findById(id).getReservas());
		return "detalles";
		
	}
	@GetMapping("/evento/new")
	public String mostrarFormulario(Model model) {
		model.addAttribute("evento", new Evento());
		return "formEvento";
	}
	
	@PostMapping("evento/add")
	public String addEvento(@ModelAttribute("evento") Evento evento) {
		eventService.save(evento);
		return "redirect:/";
	}
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
	
	
	@GetMapping("evento/borrar/{id}")
	public String borrarReserva(@PathVariable("id") Long id, Model model) {
		Evento eventABorrar = eventService.findById(id);
		if (eventABorrar != null) 
			eventService.delete(eventABorrar);
	    else 
	    	return "redirect:/?error=true";
	    
		return "redirect:/eventos";
	}
	
	
	
}
