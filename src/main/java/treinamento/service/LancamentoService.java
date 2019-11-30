package treinamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import treinamento.exception.LancamentoNaoEncontradoException;
import treinamento.model.Lancamento;
import treinamento.repository.LancamentoRepository;


@Service
public class LancamentoService {
	
	
	@Autowired
	private LancamentoRepository lancamentoRepository;

	public ResponseEntity<List<Lancamento>> listar() {

		List<Lancamento> lista = lancamentoRepository.findAll();

		if (lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

	public Lancamento cadastrar(Lancamento lancamento) {
		return lancamentoRepository.save(lancamento);
	}

	public ResponseEntity<Lancamento> buscar(Long id) {

		Optional<Lancamento> lancamentoBuscadoAux = lancamentoRepository.findById(id);
		if (lancamentoBuscadoAux.isPresent()) {
			Lancamento lancamentoBuscado = lancamentoBuscadoAux.get();
			return ResponseEntity.status(HttpStatus.OK).body(lancamentoBuscado);
		} else {
			throw new LancamentoNaoEncontradoException("Lancamento não encontrado");
		}
	}

	public ResponseEntity<Lancamento> deletar(Long id) {
		Optional<Lancamento> lancamentoBuscadaAux = this.lancamentoRepository.findById(id);
		if (lancamentoBuscadaAux.isPresent()) {
			lancamentoRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			throw new LancamentoNaoEncontradoException("Lancamento não encontrado");
		}
	}
	


}
