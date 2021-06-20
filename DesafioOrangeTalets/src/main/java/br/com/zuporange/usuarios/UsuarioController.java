package br.com.zuporange.usuarios;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zuporange.usuarios.dto.UsuarioRequest;
import br.com.zuporange.usuarios.dto.UsuarioResponse;
import br.com.zuporange.usuarios.dto.UsuarioVeiculoResponse;
import br.com.zuporange.veiculo.Veiculo;
import br.com.zuporange.veiculo.VeiculoRepository;
import br.com.zuporange.veiculo.dto.VeiculoResponse;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@PostMapping
	public ResponseEntity<UsuarioResponse> cadastro(@RequestBody @Valid UsuarioRequest request, UriComponentsBuilder uriComponentsBuilder){
		
		Usuario usuario = request.converter();
		Optional<Usuario> checarCpf = usuarioRepository.findByCpf(usuario.getCpf());
		Optional<Usuario> checarEmail = usuarioRepository.findByEmail(usuario.getEmail());
		
		if(checarCpf.isPresent()) {
			
			return new ResponseEntity<UsuarioResponse>(HttpStatus.BAD_REQUEST);

		}
		if(checarEmail.isPresent()) {
			
			return new ResponseEntity<UsuarioResponse>(HttpStatus.BAD_REQUEST);

		}
		
		usuarioRepository.save(usuario);
		
		URI uriUsuario = uriComponentsBuilder.path("/usuarios/{id}").build(usuario.getId());
		
		return ResponseEntity.created(uriUsuario).body(new UsuarioResponse(usuario));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioVeiculoResponse> listarUsuariosCarro(@PathVariable("id") Long id, UriComponentsBuilder uriComponentsBuilder) {
		

		Optional<Veiculo> retornaListaVeiculos = veiculoRepository.findById(id);
		
		if(retornaListaVeiculos.isPresent()) {
			
			URI uriUsuariosCarro = uriComponentsBuilder.path("/usuarios/{id}").build(retornaListaVeiculos.get().getId());
			
			return ResponseEntity.created(uriUsuariosCarro).body(new UsuarioVeiculoResponse(retornaListaVeiculos.get()));
			
		}
		
		return new ResponseEntity<UsuarioVeiculoResponse>(HttpStatus.BAD_REQUEST);
		
	}

	
}
