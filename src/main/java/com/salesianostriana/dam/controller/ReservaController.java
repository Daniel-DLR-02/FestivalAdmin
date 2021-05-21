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
import com.salesianostriana.dam.model.Reserva;
import com.salesianostriana.dam.servicios.EventoService;
import com.salesianostriana.dam.servicios.ReservaService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReservaController {

	private final ReservaService reservaService;
	private final EventoService eventoService;
	
	@GetMapping("/reservas")
	public String listarReservas(Model model, 
			@RequestParam("q") Optional<String> consulta) {
	
		if(consulta.isEmpty()) 
			model.addAttribute("reservas",reservaService.findAll());
		else
			model.addAttribute("reservas",reservaService.reservasPorNombre(consulta.get()));
		
		return "lista_reservas";
	}

	@GetMapping("/reserva/new/{id}")
	public String mostrarFormulario(@PathVariable("id") Long eventoId, Model model) {
		
		model.addAttribute("eventos", eventoService.findById(eventoId));
		model.addAttribute("reserva", new Reserva());
		
		return "formReserva";
	}
	
	//@PostMapping({"/reserva/add/{id}"})
	@PostMapping("/reserva/add")
	public String procesaFormulario(@ModelAttribute("reserva") Reserva reserva) {
		reservaService.save(reserva);
		return "redirect:/reservas";
	}
	
	@GetMapping("editar/{id}")
	public String editarForm(@PathVariable("id") long id, Model model) {
		Reserva reservaAEditar= reservaService.findById(id);
		if (reservaAEditar != null) {
			Evento event = reservaAEditar.getEvento();
			reservaAEditar.setIdReserva(id);
			
			model.addAttribute("reserva",reservaAEditar);
			model.addAttribute("eventos",event);
			return "formReserva";
		} else {
			return "redirect:/";
		}
	}
	
	
	@GetMapping("/borrar/{id}")
	public String borrarReserva(@PathVariable("id") Long id, Model model) {
		Reserva reservaABorrar = reservaService.findById(id);
		if (reservaABorrar != null) 
			reservaService.delete(reservaABorrar);
	    else 
	    	return "redirect:/?error=true";
	    
		return "redirect:/reservas";
	}
}
