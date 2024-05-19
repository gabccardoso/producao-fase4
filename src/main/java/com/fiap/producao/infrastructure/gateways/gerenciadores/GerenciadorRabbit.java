package com.fiap.producao.infrastructure.gateways.gerenciadores;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.producao.application.gateways.ProducaoPedidosGateway;
import com.fiap.producao.entities.ProducaoPedidos;
import com.fiap.producao.infrastructure.controllers.enums.Status;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class GerenciadorRabbit {

    private final ProducaoPedidosGateway producaoPedidosGateway;

    private static final String QUEUE_NAME = "pedidos-pagos";

    public GerenciadorRabbit(ProducaoPedidosGateway producaoPedidosGateway) {
        this.producaoPedidosGateway = producaoPedidosGateway;
    }


    @RabbitListener(queues = QUEUE_NAME)
    public void receiveMessage(String message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(message);
        long idPedido = jsonNode.get("idPedido").asLong();
        ProducaoPedidos producaoPedidos = new ProducaoPedidos(idPedido, Status.RECEBIDO);
        producaoPedidosGateway.salvaPedido(producaoPedidos);
    }
}
