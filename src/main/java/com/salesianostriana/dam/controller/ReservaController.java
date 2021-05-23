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

/**
 * Esta clase es la clase controlador del objeto Reserva.
 * @author Daniel de Luna Rodríguez
 *
 */
@Controller
@RequiredArgsConstructor
public class ReservaController {

	private final ReservaService reservaService;
	private final EventoService eventoService;
	
	/**
	 * Este método esta encargado de filtrar las reservas por su nombre asociado,
	 * mediante una consulta enviada por el usuario.Si esta consulta está vacía,
	 * pues devuelve todas las reservas registradas.
	 * @param model Parámetro encargado de devolver datos.
	 * @param consulta Este parámetro es la consulta enviada por el usuario.
	 * @return Como devolución tenemos una lista de todas las reservas o con el filtro aplicado.
	 */
	@GetMapping("/reservas")
	public String listarReservas(Model model, 
			@RequestParam("q") Optional<String> consulta) {
	
		if(consulta.isEmpty()) 
			model.addAttribute("reservas",reservaService.findAll());
		else
			model.addAttribute("reservas",reservaService.reservasPorNombre(consulta.get()));
		
		return "lista_reservas";
	}

	/**
	 * Este método está encargado de mostrar el formulario de registro de las reservas.
	 * @param eventoId Este parámetro es el id del evento.
	 * @param model Parámetro encargado de devolver datos.
	 * @return Este método devuelve el formulario de reserva de eventos.
	 */
	@GetMapping("/reserva/new/{id}")
	public String mostrarFormulario(@PathVariable("id") Long eventoId, Model model) {
		
		model.addAttribute("eventos", eventoService.findById(eventoId));
		model.addAttribute("reserva", new Reserva());
		
		return "formReserva";
	}
	
	/**
	 * Este metodo esta encargado de procesar el formulario de registro de reservas.
	 * @param reserva Este parámetro es la reserva a introducir en la base de datos.
	 * @return Devulve un listado de las reservas registradas en la base de datos.
	 */
	@PostMapping("/reserva/add")
	public String procesaFormulario(@ModelAttribute("reserva") Reserva reserva) {
		reservaService.save(reserva);
		return "redirect:/reservas";
	}
	
	/**
	 * Este método esta encargado de mostrar el formulario para editar una reserva.
	 * @param id Este es un parámetro pasado por el path, este detalla cual es la reserva a editar.
	 * @param model Parámetro encargado de devolver datos.
	 * @return Devuelve el formulario de reserva con los campos correspondientes rellenos.
	 */
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
	
	/**
	 * Este método se encarga de borrar la reserva seleccionada de la base de datos.
	 * @param id Este parámetro está pasado por el path, y detalla cual es la reserva a eliminar.
	 * @param model Parámetro encargado de devolver datos.
	 * @return Devuelve la misma lista de reservas.
	 */
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
