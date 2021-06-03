package pe.org.incatrek.controller;

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

import pe.org.incatrek.model.Proveedor;
import pe.org.incatrek.service.IProveedorService;

@Controller
@RequestMapping("/proveedor")

public class ProveedorController {

		@Autowired
		private IProveedorService pService;
		
		@RequestMapping("/bienvenido")
		public String irProveedorBienvenido() {
			return "bienvenido";
		}
		
		@RequestMapping("/")
		public String irProveedor(Map<String,Object>model) {
			model.put("listaProveedores", pService.listar());
			return "listProveedor";
		}
		
		@RequestMapping("/irRegistrar")
		public String irPaginaRegistrar(Model model) {
			model.addAttribute("proveedor", new Proveedor());
			return "proveedor";
		}
		
		@RequestMapping("/registrar")
		public String registrar (@ModelAttribute Proveedor objProveedor,BindingResult binRes,Model model)throws ParseException
			{
				if(binRes.hasErrors())
				return("proveedor");
				else {
					boolean flag = pService.insertar(objProveedor);
					if (flag)
						return "redirect:/proveedor/listar";
					else {
						model.addAttribute("mensaje", "Ocurrio un error");
						return "redirect:/proveedor/irRegistrar";
					}
				}
			}
			
		@RequestMapping("/modificar/{id}")
		public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
			Optional<Proveedor> objProveedor = pService.listarId(id);
			if(objProveedor == null) {
				objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
				return "redirect:/proveedor/listar";
			}
			else {
				model.addAttribute("proveedor", objProveedor);
				return "proveedor";
			}
		}		
			
		@RequestMapping("/eliminar")
		public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
			try {
				if (id != null && id>0) {
					pService.eliminar(id);
					model.put("listaProveedores", pService.listar());
				}
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
				model.put("mensaje", "Ocurrio un error");
				model.put("listaProveedores", pService.listar());
			}
			return "listProveedor";
		}
		
		@RequestMapping("/listar")
		public String listar(Map<String, Object> model) {
			model.put("listaProveedores", pService.listar());
			return "listProveedor";
		}
		
		
		
}
