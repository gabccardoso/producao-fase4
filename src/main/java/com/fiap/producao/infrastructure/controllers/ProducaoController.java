package com.fiap.producao.infrastructure.controllers;

import com.fiap.producao.application.useCases.ProducaoPedidoInteractor;
import com.fiap.producao.entities.ProducaoPedidos;
import com.fiap.producao.infrastructure.controllers.dto.ProducaoPedidoDTO;
import com.fiap.producao.infrastructure.controllers.dto.ProducaoPedidoDTOMapper;
import com.fiap.producao.infrastructure.controllers.enums.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/producao")
public class ProducaoController {

    private final ProducaoPedidoInteractor producaoPedidoInteractor;
    private final ProducaoPedidoDTOMapper producaoPedidoDTOMapper;

    public ProducaoController(ProducaoPedidoInteractor producaoPedidoInteractor, ProducaoPedidoDTOMapper producaoPedidoDTOMapper) {
        this.producaoPedidoInteractor = producaoPedidoInteractor;
        this.producaoPedidoDTOMapper = producaoPedidoDTOMapper;
    }

    @PostMapping(value = "criarPedido")
    public ResponseEntity<ProducaoPedidoDTO> createOrderToProduction(@RequestBody ProducaoPedidoDTO producaoPedidoDTO){
        ProducaoPedidos producaoPedidos = producaoPedidoInteractor.
                criarPedidoNaProducao(producaoPedidoDTOMapper.toProducaoPedido(producaoPedidoDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(producaoPedidoDTOMapper.toProducaoPedidoDTO(producaoPedidos));
    }

    @GetMapping(value = "buscarStatusDoPedido/{id}")
    public ResponseEntity<String> findByOrderId(@PathVariable Long id){
        ProducaoPedidos producaoPedidos = producaoPedidoInteractor.buscarStatusDoPedido(id);
        return ResponseEntity.ok(producaoPedidos.status().name());
    }


    @PutMapping(value = "alterarStatusDoPedido/{id}")
    public ResponseEntity<ProducaoPedidos> alterarStatusDoPedido(@RequestParam String status, @PathVariable Long id){
        ProducaoPedidos producaoPedidos = producaoPedidoInteractor.alterarStatusDoPedido(id, Status.valueOf(status));
        return ResponseEntity.ok(producaoPedidos);
    }
}
