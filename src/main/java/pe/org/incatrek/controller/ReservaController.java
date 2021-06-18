package pe.org.incatrek.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.org.incatrek.model.Guia;
import pe.org.incatrek.model.Paquete;
import pe.org.incatrek.model.Turista;
import pe.org.incatrek.model.Reserva;

import pe.org.incatrek.service.IPaqueteService;
import pe.org.incatrek.service.ITuristaService;
import pe.org.incatrek.service.IReservaService;
import pe.org.incatrek.service.IGuiaService;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

		@Autowired
		private IPaqueteService pService;
		@Autowired
		private ITuristaService tService;
		@Autowired
		private IReservaService rService;
		@Autowired
		private IGuiaService gService;
		
		@RequestMapping("/bienvenido")
		public String irPaginaBienvenida() {
			return "bienvenido";
		}
		
		@RequestMapping("/")
		public String irPaginaListadoReservas(Map<String,Object>model) {
			model.put("listaReservas", rService.listar());
			return "listReserva";
		}
		
		@RequestMapping("/irRegistrar")
		public String irPaginaRegistrar(Model model) {
			
			model.addAttribute("listaPaquetes", pService.listar());
			model.addAttribute("listaTuristas", tService.listar());
			model.addAttribute("listaGuias", gService.listar());
			
			model.addAttribute("paquete", new Paquete());
			model.addAttribute("turista", new Turista());
			model.addAttribute("reserva", new Reserva());
			model.addAttribute("guia", new Guia());
			
			return "reserva";
		}
		
		@RequestMapping("/registrar")
		public String registrar (@ModelAttribute Reserva objReserva,BindingResult binRes,Model model)
		throws ParseException
			{
				if(binRes.hasErrors()) {
				model.addAttribute("listaPaquetes", pService.listar());
				model.addAttribute("listaTuristas", tService.listar());
				model.addAttribute("listaGuias", gService.listar());
				return("reserva");
				}
				else {
					boolean flag = rService.insertar(objReserva);
					if (flag)
						return "redirect:/reserva/listar";
					else {
						model.addAttribute("mensaje", "Ocurrio un error");
						return "redirect:/reserva/irRegistrar";
					}
				}
			}
			
		@RequestMapping("/modificar/{id}")
		public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException 
		{
			Optional<Reserva> objReserva = rService.listarId(id);
			if(objReserva == null) {
				objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
				return "redirect:/reserva/listar";
			}
			else {
				model.addAttribute("listaPaquetes", pService.listar());
				model.addAttribute("listaTuristas", tService.listar());
				model.addAttribute("listaGuias", gService.listar());
				
				if(objReserva.isPresent())
					objReserva.ifPresent(o -> model.addAttribute("reserva" ,o ));
				return "reserva";
			}
		}		
			
		@RequestMapping("/eliminar")
		public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
			try {
				if (id != null && id>0) {
					rService.eliminar(id);
					model.put("listaReservas", rService.listar());
				}
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
				model.put("mensaje", "Ocurrio un error");
				model.put("listaReservas", rService.listar());
			}
			return "listReservas";
		}
		
		@RequestMapping("/listar")
		public String listar(Map<String, Object> model) {
			model.put("listaReservas", rService.listar());
			return "listReservas";
		}
		
		@RequestMapping("/irBuscar")
		public String buscar(Model model) {
			model.addAttribute("reserva", new Reserva());
			return "buscarReserva";
		}
		
		@RequestMapping("/buscar")
		public String findByCategory(Map<String, Object> model, @ModelAttribute Reserva reserva)throws ParseException	
		{
			List<Reserva> listaReservas;
			reserva.setNombreReserva(reserva.getNombreReserva());
			listaReservas = rService.buscarNombreReserva(reserva.getNombreReserva());
			if (listaReservas.isEmpty()) {
				listaReservas = rService.buscarPaquete(reserva.getNombreReserva());
			}
			if (listaReservas.isEmpty()) {
				listaReservas = rService.buscarTurista(reserva.getNombreReserva());
			}
			if (listaReservas.isEmpty()) {
				model.put("mensaje", "No se encontraron coincidencias");
			}
			model.put("listaReservas", listaReservas);
			return "buscarReserva";
		}
		
}
