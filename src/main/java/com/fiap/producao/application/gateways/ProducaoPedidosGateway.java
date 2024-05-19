package com.fiap.producao.application.gateways;


import com.fiap.producao.entities.ProducaoPedidos;
import com.fiap.producao.infrastructure.controllers.enums.Status;

public interface ProducaoPedidosGateway {
    ProducaoPedidos buscarStatusDoPedido(Long pedidoId);
    ProducaoPedidos alterarStatusDoPedido(Long pedidoId, Status status);

    ProducaoPedidos salvaPedido(ProducaoPedidos producaoPedidos);
}
