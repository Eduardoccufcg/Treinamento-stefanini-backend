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

import treinamento.model.Pessoa;
import treinamento.service.PessoaService;

@RestController
@RequestMapping({ "/pessoas" })
public class PessoaResource {
	
	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public ResponseEntity<List<Pessoa>> listar() {
		
		return pessoaService.listar();
		
	}
	@PostMapping
	public ResponseEntity<Pessoa> cadastrar(@RequestBody Pessoa pessoa) {

		Pessoa pessoaCadastrada = this.pessoaService.cadastrar(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaCadastrada);

	}
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> buscar(@PathVariable Long id) {

		return this.pessoaService.buscar(id);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Pessoa> deletar(@PathVariable Long id) {
		return this.pessoaService.deletar(id);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @RequestBody Pessoa pessoa) {

		Pessoa pessoaAtualizada = pessoaService.atualizar(id, pessoa);
		return ResponseEntity.status(HttpStatus.OK).body(pessoaAtualizada);

	}
	
	
	

}
