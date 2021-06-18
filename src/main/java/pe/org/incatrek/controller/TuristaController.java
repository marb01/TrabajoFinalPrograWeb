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

import pe.org.incatrek.model.Turista;
import pe.org.incatrek.service.ITuristaService;

@Controller
@RequestMapping("/turista")

public class TuristaController {

		@Autowired
		private ITuristaService tService;
		
		@RequestMapping("/bienvenido")
		public String irTuristaBienvenido() {
			return "bienvenido";
		}
		
		@RequestMapping("/")
		public String irTurista(Map<String,Object>model) {
			model.put("listaTuristas", tService.listar());
			return "listTurista";
		}
		
		@RequestMapping("/irRegistrar")
		public String irPaginaRegistrar(Model model) {
			model.addAttribute("turista", new Turista());
			return "turista";
		}
		
		@RequestMapping("/registrar")
		public String registrar (@ModelAttribute Turista objTurista,BindingResult binRes,Model model)throws ParseException
		{
			if(binRes.hasErrors())
				return("turista");
			else {
				int rpta = tService.insertar(objTurista);
				if (rpta > 0) {
					model.addAttribute("mensaje", "El DNI del turista ya se encuentra registrado");
					return "turista";
				}
				else {
					model.addAttribute("mensaje", "Se guardo correctamente");
					return "redirect:/turista/listar";
				}
			}
		}
		
		@RequestMapping("/modificar/{id}")
		public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
			Optional<Turista> objTurista = tService.listarId(id);
			if(objTurista == null) {
				objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
				return "redirect:/turista/listar";
			}
			else {
				model.addAttribute("turista", objTurista);
				return "turista";
			}
		}		
			
		@RequestMapping("/eliminar")
		public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
			try {
				if (id != null && id>0) {
					tService.eliminar(id);
					model.put("listaTuristas", tService.listar());
				}
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
				model.put("mensaje", "Ocurrio un error");
				model.put("listaTuristas", tService.listar());
			}
			return "listTurista";
		}
		
		@RequestMapping("/listar")
		public String listar(Map<String, Object> model) {
			model.put("listaTuristas", tService.listar());
			return "listTurista";
		}
		
		
		@RequestMapping("/irBuscar")
		public String buscar(Model model) {
			model.addAttribute("turista", new Turista());
			return "buscarTurista";
		}
		
		@RequestMapping("/buscar")
		public String findByCategory(Map<String, Object> model, @ModelAttribute Turista turista)throws ParseException	
		{
			List<Turista> listaTuristas;
			turista.setNombreTurista(turista.getNombreTurista());
			listaTuristas = tService.buscarPorNombre(turista.getNombreTurista());
			if (listaTuristas.isEmpty()) {
				listaTuristas = tService.buscarPorDNI(turista.getNombreTurista());
			}
			if (listaTuristas.isEmpty()) {
				model.put("mensaje", "No se encontraron coincidencias");
			}
			model.put("listaTuristas", listaTuristas);
			return "buscarTurista";
		}
		
		
		
}
