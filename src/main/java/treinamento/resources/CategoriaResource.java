package treinamento.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import treinamento.model.Categoria;
import treinamento.service.CategoriaService;

@RestController
@RequestMapping({"/categorias"})
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping()
	public List<Categoria> listar(){
		
		return categoriaService.listar();
		
	}
	

}
