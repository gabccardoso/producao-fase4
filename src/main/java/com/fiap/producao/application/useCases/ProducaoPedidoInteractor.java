package com.fiap.producao.application.useCases;


import com.fiap.producao.application.gateways.ProducaoPedidosGateway;
import com.fiap.producao.entities.ProducaoPedidos;
import com.fiap.producao.infrastructure.controllers.dto.ProducaoPedidoDTO;
import com.fiap.producao.infrastructure.controllers.enums.Status;

public class ProducaoPedidoInteractor {

    private ProducaoPedidosGateway producaoPedidosGateway;

    public ProducaoPedidoInteractor(ProducaoPedidosGateway producaoPedidosGateway) {
        this.producaoPedidosGateway = producaoPedidosGateway;
    }

    public ProducaoPedidos buscarStatusDoPedido(Long pedidoId){
        return producaoPedidosGateway.buscarStatusDoPedido(pedidoId);
    }

    public ProducaoPedidos alterarStatusDoPedido(Long pedidoId, Status status){
        return producaoPedidosGateway.alterarStatusDoPedido(pedidoId, status);
    }

    public ProducaoPedidos criarPedidoNaProducao(ProducaoPedidos producaoPedidos){
        return producaoPedidosGateway.salvaPedido(producaoPedidos);
    }
}
