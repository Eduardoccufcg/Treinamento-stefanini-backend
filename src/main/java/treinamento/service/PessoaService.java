package treinamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import treinamento.exception.CategoriaNaoEncontradaException;
import treinamento.exception.PessoaNaoEncontradaException;
import treinamento.model.Pessoa;
import treinamento.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public ResponseEntity<List<Pessoa>> listar() {

		List<Pessoa> lista = pessoaRepository.findAll();

		if (lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	public Pessoa cadastrar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public ResponseEntity<Pessoa> deletar(Long id) {
		Optional<Pessoa> pessoaBuscadaAux = this.pessoaRepository.findById(id);
		if (pessoaBuscadaAux.isPresent()) {
			pessoaRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			throw new CategoriaNaoEncontradaException("Pessoa não encontrada");
		}
	}

	public ResponseEntity<Pessoa> buscar(Long id) {
		Optional<Pessoa> pessoaBuscadaAux = pessoaRepository.findById(id);
		if (pessoaBuscadaAux.isPresent()) {
			Pessoa pessoaBuscada = pessoaBuscadaAux.get();
			return ResponseEntity.status(HttpStatus.OK).body(pessoaBuscada);
		} else {
			throw new PessoaNaoEncontradaException("Pessoa não encontrada");
		}
	}

	public Pessoa atualizar(Long id, Pessoa pessoa) {
		Optional<Pessoa> pessoaSerAtualizada = pessoaRepository.findById(id);

		if (pessoaSerAtualizada.isPresent()) {
			Pessoa pessoaAux = pessoaSerAtualizada.get();

			BeanUtils.copyProperties(pessoa, pessoaAux, "codigo");
			pessoaRepository.save(pessoaAux);
			return pessoaAux;

		} else {
			throw new CategoriaNaoEncontradaException("Pessoa não encontrada");
		}
	}

}
