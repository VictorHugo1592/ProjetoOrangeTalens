package br.com.zuporange.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.zuporange.veiculo.Veiculo;
import br.com.zuporange.veiculo.dto.VeiculoResponse;

@FeignClient(name="consulta", url="https://parallelum.com.br/fipe/api/v1/")
public interface FipeFeignClient {

    @GetMapping("carros/marcas/{marcas}/modelos/{modelos}/anos/{ano}")
    DetalhesVeiculosFeignResponse detalhesVeiculos(@PathVariable String marcas, @PathVariable String modelos,
                                            @PathVariable String ano);
	
}
