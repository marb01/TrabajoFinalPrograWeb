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

import pe.org.incatrek.model.Paquete;
import pe.org.incatrek.service.IPaqueteService;

@Controller
@RequestMapping("/paquete")

public class PaqueteController {

		@Autowired
		private IPaqueteService pService;
		
		@RequestMapping("/bienvenido")
		public String irPaqueteBienvenido() {
			return "bienvenido";
		}
		
		@RequestMapping("/")
		public String irPaquete(Map<String,Object>model) {
			model.put("listaPaquetes", pService.listar());
			return "listPaquete";
		}
		
		@RequestMapping("/irRegistrar")
		public String irPaginaRegistrar(Model model) {
			model.addAttribute("paquete", new Paquete());
			return "paquete";
		}
		
		@RequestMapping("/registrar")
		public String registrar (@ModelAttribute Paquete objPaquete,BindingResult binRes,Model model)throws ParseException
			{
				if(binRes.hasErrors())
				return("paquete");
				else {
					boolean flag = pService.insertar(objPaquete);
					if (flag)
						return "redirect:/paquete/listar";
					else {
						model.addAttribute("mensaje", "Ocurrio un error");
						return "redirect:/paquete/irRegistrar";
					}
				}
			}
			
		@RequestMapping("/modificar/{id}")
		public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
			Optional<Paquete> objPaquete = pService.listarId(id);
			if(objPaquete == null) {
				objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
				return "redirect:/paquete/listar";
			}
			else {
				model.addAttribute("paquete", objPaquete);
				return "paquete";
			}
		}		
			
		@RequestMapping("/eliminar")
		public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
			try {
				if (id != null && id>0) {
					pService.eliminar(id);
					model.put("listaPaquetes", pService.listar());
				}
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
				model.put("mensaje", "Ocurrio un error");
				model.put("listaPaquetes", pService.listar());
			}
			return "listPaquete";
		}
		
		@RequestMapping("/listar")
		public String listar(Map<String, Object> model) {
			model.put("listaPaquetes", pService.listar());
			return "listPaquete";
		}
		
		@RequestMapping("/irBuscar")
		public String buscar(Model model) {
			model.addAttribute("paquete", new Paquete());
			return "buscarPaquete";
		}
		
		@RequestMapping("/buscar")
		public String findByCategory(Map<String, Object> model, @ModelAttribute Paquete paquete)throws ParseException	
		{
			List<Paquete> listaPaquetes;
			paquete.setNombrePaquete(paquete.getNombrePaquete());
			listaPaquetes = pService.buscarPorNombre(paquete.getNombrePaquete());
			if (listaPaquetes.isEmpty()) {
				listaPaquetes = pService.buscarPorNombre(paquete.getNombrePaquete());
			}
			if (listaPaquetes.isEmpty()) {
				model.put("mensaje", "No se encontraron coincidencias");
			}
			model.put("listaPaquetes", listaPaquetes);
			return "buscarPaquete";
		}
		
		
}
