package treinamento.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import treinamento.model.Lancamento;
import treinamento.service.LancamentoService;

@RestController
@RequestMapping({ "/lancamentos" })
public class LancamentoResource {

	@Autowired
	private LancamentoService lancamentoService;

	@GetMapping
	public ResponseEntity<List<Lancamento>> listar() {

		return lancamentoService.listar();

	}

	@PostMapping
	public ResponseEntity<Lancamento> cadastrar(@RequestBody Lancamento lancamento) {

		Lancamento lancamentoCadastrado = this.lancamentoService.cadastrar(lancamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoCadastrado);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Lancamento> buscar(@PathVariable Long id) {

		return this.lancamentoService.buscar(id);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Lancamento> deletar(@PathVariable Long id) {
		return this.lancamentoService.deletar(id);

	}

}
