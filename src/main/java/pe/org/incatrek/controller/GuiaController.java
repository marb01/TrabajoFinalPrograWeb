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
import pe.org.incatrek.service.IGuiaService;

@Controller
@RequestMapping("/guia")
public class GuiaController {

		@Autowired
		private IGuiaService gService;
		
		@RequestMapping("/bienvenido")
		public String irGuiaBienvenido() {
			return "bienvenido";
		}
		
		@RequestMapping("/")
		public String irGuia(Map<String,Object>model) {
			model.put("listaGuias", gService.listar());
			return "listGuia";
		}
		
		@RequestMapping("/irRegistrar")
		public String irPaginaRegistrar(Model model) {
			model.addAttribute("guia", new Guia());
			return "guia";
		}
		
		@RequestMapping("/registrar")
		public String registrar (@ModelAttribute Guia objGuia,BindingResult binRes,Model model)throws ParseException
			{
				if(binRes.hasErrors())
					return("guia");
				else {
					int rpta = gService.insertar(objGuia);
					if (rpta > 0) {
						model.addAttribute("mensaje", "El DNI del guia ya se encuentra registrado");
						return "guia";
					}
					else {
						model.addAttribute("mensaje", "Se guardo correctamente");
						return "redirect:/guia/listar";
					}
				}
			}
		
			
		@RequestMapping("/modificar/{id}")
		public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
			Optional<Guia> objGuia = gService.listarId(id);
			if(objGuia == null) {
				objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
				return "redirect:/guia/listar";
			}
			else {
				model.addAttribute("guia", objGuia);
				return "guia";
			}
		}		
			
		@RequestMapping("/eliminar")
		public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
			try {
				if (id != null && id>0) {
					gService.eliminar(id);
					model.put("listaGuias", gService.listar());
				}
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
				model.put("mensaje", "Ocurrio un error");
				model.put("listaGuias", gService.listar());
			}
			return "listGuia";
		}
		
		@RequestMapping("/listar")
		public String listar(Map<String, Object> model) {
			model.put("listaGuias", gService.listar());
			return "listGuia";
		}
		
		@RequestMapping("/irBuscar")
		public String buscar(Model model) {
			model.addAttribute("guia", new Guia());
			return "buscarGuia";
		}
		
		@RequestMapping("/buscar")
		public String findByCategory(Map<String, Object> model, @ModelAttribute Guia guia)throws ParseException	
		{
			List<Guia> listaGuias;
			guia.setNombreGuia(guia.getNombreGuia());
			listaGuias = gService.buscarPorNombre(guia.getNombreGuia());
			if (listaGuias.isEmpty()) {
				listaGuias = gService.buscarPorDNI(guia.getNombreGuia());
			}
			if (listaGuias.isEmpty()) {
				model.put("mensaje", "No se encontraron coincidencias");
			}
			model.put("listaGuias", listaGuias);
			return "buscarGuia";
		}
}
