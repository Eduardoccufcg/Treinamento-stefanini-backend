package treinamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import treinamento.exception.CategoriaNaoEncontradaException;
import treinamento.model.Categoria;
import treinamento.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public ResponseEntity<List<Categoria>> listar() {

	List<Categoria> lista = categoriaRepository.findAll();
		
		if(lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(lista);

	}

	public Categoria cadastrar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public ResponseEntity<Categoria> buscar(Long id) {
		
		Optional<Categoria> categoriaBuscadaAux = categoriaRepository.findById(id);
		if (categoriaBuscadaAux.isPresent()) {
			Categoria categoriaBuscada = categoriaBuscadaAux.get();
			return ResponseEntity.status(HttpStatus.OK).body(categoriaBuscada);
		} else {
			throw new CategoriaNaoEncontradaException("Categoria não encontrada");
		}
	}

	public ResponseEntity<Categoria> deletar(Long id) {
		
		Optional<Categoria> categoriaBuscadaAux = this.categoriaRepository.findById(id);
		if (categoriaBuscadaAux.isPresent()) {
			categoriaRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			throw new CategoriaNaoEncontradaException("Categoria não encontrada");
		}
		
	}

	public Categoria atualizar(Long id, Categoria categoria) {
		
		Optional<Categoria> categoriaSerAtualizada = categoriaRepository.findById(id);
		
		if(categoriaSerAtualizada.isPresent()) {
			Categoria categoriaAux = categoriaSerAtualizada.get();
			
			BeanUtils.copyProperties(categoria, categoriaAux, "codigo");
			categoriaRepository.save(categoriaAux);
			return categoriaAux;
			
		}else {
			throw new CategoriaNaoEncontradaException("Categoria não encontrada");
		}
	
	}

}
