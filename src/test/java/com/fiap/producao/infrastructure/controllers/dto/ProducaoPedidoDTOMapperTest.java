package com.fiap.producao.infrastructure.controllers.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fiap.producao.entities.ProducaoPedidos;
import com.fiap.producao.infrastructure.controllers.ProducaoController;
import com.fiap.producao.infrastructure.controllers.enums.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProducaoPedidoDTOMapperTest {

    private ProducaoPedidoDTOMapper producaoPedidoDTOMapper;

    @BeforeEach
    public void setup() {
        producaoPedidoDTOMapper = new ProducaoPedidoDTOMapper();
    }

    @Test
    public void testToProducaoPedidoDTO() {
        ProducaoPedidos producaoPedidos = new ProducaoPedidos(1L, Status.RECEBIDO);

        ProducaoPedidoDTO producaoPedidoDTO = producaoPedidoDTOMapper.toProducaoPedidoDTO(producaoPedidos);

        assertEquals(producaoPedidos.idPedido(), producaoPedidoDTO.getIdPedido());
        assertEquals(producaoPedidos.status(), producaoPedidoDTO.getStatus());
    }

    @Test
    public void testToProducaoPedido() {
        ProducaoPedidoDTO producaoPedidoDTO = new ProducaoPedidoDTO(1L, Status.RECEBIDO);

        ProducaoPedidos producaoPedidos = producaoPedidoDTOMapper.toProducaoPedido(producaoPedidoDTO);

        assertEquals(producaoPedidoDTO.getIdPedido(), producaoPedidos.idPedido());
        assertEquals(producaoPedidoDTO.getStatus(), producaoPedidos.status());
    }
}
