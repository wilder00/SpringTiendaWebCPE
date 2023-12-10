package pe.edu.tecsup.tienda.webs;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.tecsup.tienda.entities.Categoria;
import pe.edu.tecsup.tienda.entities.Producto;
import pe.edu.tecsup.tienda.services.CategoriaService;
import pe.edu.tecsup.tienda.services.ProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	private Logger logger = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ProductoService productoService;

	@GetMapping()
	public String index(Model model) throws Exception {
		logger.info("call index()");
		
		List<Producto> prods = productoService.findAll();
		model.addAttribute("productos", prods);
		
		return "productos/index";
		
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) throws Exception {
		logger.info("edit edit(id: " + id + ")");
		
		List<Categoria> categorias = categoriaService.findAll();
		model.addAttribute("categorias", categorias);
		
		Producto producto = productoService.findById(id);
		model.addAttribute("producto", producto);
		
		return "productos/edit";
	}


	
}
