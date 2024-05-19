package com.fiap.producao.infrastructure.gateways;


import com.fiap.producao.entities.ProducaoPedidos;
import com.fiap.producao.infrastructure.persistence.ProducaoPedidoEntity;

public class ProducaoPedidoEntityMapper {
    ProducaoPedidoEntity toEntity(ProducaoPedidos producaoPedidos){
        return new ProducaoPedidoEntity(producaoPedidos.idPedido(), producaoPedidos.status());
    }

    ProducaoPedidos toDomainObject(ProducaoPedidoEntity producaoPedidoEntity){
        return new ProducaoPedidos(producaoPedidoEntity.getIdPedido(), producaoPedidoEntity.getStatus());
    }
}
