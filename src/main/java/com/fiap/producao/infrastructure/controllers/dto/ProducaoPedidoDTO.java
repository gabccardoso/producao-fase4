package com.fiap.producao.infrastructure.controllers.dto;


import com.fiap.producao.infrastructure.controllers.enums.Status;

public class ProducaoPedidoDTO {

    private Long idPedido;
    private Status status;

    public ProducaoPedidoDTO(Long idPedido, Status status) {
        this.idPedido = idPedido;
        this.status = status;
    }

    public ProducaoPedidoDTO() {
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
