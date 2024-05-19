package com.fiap.producao.infrastructure.controllers.dto;


import com.fiap.producao.entities.ProducaoPedidos;

public class ProducaoPedidoDTOMapper {
    public ProducaoPedidoDTO toProducaoPedidoDTO(ProducaoPedidos producaoPedidos){
        return new ProducaoPedidoDTO(producaoPedidos.idPedido(), producaoPedidos.status());
    }

    public ProducaoPedidos toProducaoPedido(ProducaoPedidoDTO producaoPedidoDTO){
        return new ProducaoPedidos(producaoPedidoDTO.getIdPedido(), producaoPedidoDTO.getStatus());
    }
}
