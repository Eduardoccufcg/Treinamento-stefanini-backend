package treinamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import treinamento.model.Categoria;
import treinamento.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> listar() {

		return categoriaRepository.findAll();

	}

	public Categoria cadastrar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public Optional<Categoria> buscar(Long id) {

		return categoriaRepository.findById(id);
	}

	public void deletar(Long id) {
		
		categoriaRepository.deleteById(id);
		
	}

	public Categoria atualizar(Long id, Categoria categoria) {
		
		Optional<Categoria> categoriaSerAtualizada = categoriaRepository.findById(id);
		
		if(categoriaSerAtualizada.isPresent()) {
			Categoria categoriaAux = categoriaSerAtualizada.get();
			
			BeanUtils.copyProperties(categoria, categoriaAux, "codigo");
			categoriaRepository.save(categoriaAux);
			return categoriaAux;
			
		}else {
			return null;
		}
	
	}

}
