package br.com.zuporange.veiculo;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zuporange.feign.DetalhesVeiculosFeignResponse;
import br.com.zuporange.feign.FipeFeignClient;
import br.com.zuporange.usuarios.UsuarioRepository;
import br.com.zuporange.usuarios.dto.UsuarioResponse;
import br.com.zuporange.veiculo.dto.VeiculoRequest;
import br.com.zuporange.veiculo.dto.VeiculoResponse;
import feign.FeignException;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private FipeFeignClient fipeFeignClient;
	
	@PostMapping
	public ResponseEntity<VeiculoResponse> cadatrar(@RequestBody @Valid VeiculoRequest request, UriComponentsBuilder uriComponentsBuilder) {
	
		
		try {
			
			DetalhesVeiculosFeignResponse detalhesVeiculosResponse = fipeFeignClient.detalhesVeiculos(request.getMarca(), 
					request.getModelo(),request.getAno());
			
			Veiculo veiculo = request.converter(usuarioRepository);
			
			veiculo.setValor(detalhesVeiculosResponse.getValor());
			
			definirRodizio(veiculo);
			
			veiculoRepository.save(veiculo);
			
			URI uriVeiculo = uriComponentsBuilder.path("/veiculos/{id}").build(veiculo.getId());
			
			return ResponseEntity.created(uriVeiculo).body(new VeiculoResponse(veiculo));
			
			
		} catch (FeignException e) {
			
			e.printStackTrace();
			
		}
		return new ResponseEntity<VeiculoResponse>(HttpStatus.BAD_REQUEST);
		
	}
	
    private void definirRodizio(Veiculo veiculo) {
    	
        String diaSemana = "";
        String ultimoDigito = veiculo.getAno().substring(3, 4);
        
        System.out.println(ultimoDigito);
        
        switch (ultimoDigito) {
            case "0" :
            case "1":
            	diaSemana = "segunda-feira";
                break;

            case "2" :
            case "3" :
            	diaSemana = "terça-feira";
            	
                break;

            case "4" :
            case "5" :
            	diaSemana = "quarta-feira";
                break;

            case "6" :
            case "7" :
            	diaSemana = "quinta-feira";
                break;

            case "8" :
            case "9" :
            	diaSemana = "sexta-feira";
                break;
                
        }
        
        veiculo.setDiaRodizio(diaSemana);
        String diaHoje = DiaDaSemana.getDiaDaSemana();
        if(diaSemana == diaHoje){
        	
            veiculo.setRodizio(true);
            
        }else {
        	
        	veiculo.setRodizio(false);
        	
        }
    }
	
	
}
