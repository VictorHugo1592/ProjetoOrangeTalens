package br.com.zuporange.veiculo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VeiculoRepository extends CrudRepository<Veiculo, Long>{
	

	List<Veiculo> findByUsuarioId(Long usuarioId);
	
}
