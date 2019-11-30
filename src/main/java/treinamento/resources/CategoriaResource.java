package treinamento.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import treinamento.model.Categoria;
import treinamento.service.CategoriaService;

@RestController
@RequestMapping({ "/categorias" })
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<Categoria>> listar() {
		
		return categoriaService.listar();
		
	}

	@PostMapping
	public ResponseEntity<Categoria> cadastrar(@RequestBody Categoria categoria) {

		Categoria categoriaCadastrada = this.categoriaService.cadastrar(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaCadastrada);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> buscar(@PathVariable Long id) {

		return this.categoriaService.buscar(id);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Categoria> deletar(@PathVariable Long id) {
		return this.categoriaService.deletar(id);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {

		Categoria categoriaAtualizada = categoriaService.atualizar(id, categoria);
		return ResponseEntity.status(HttpStatus.OK).body(categoriaAtualizada);

	}

}
