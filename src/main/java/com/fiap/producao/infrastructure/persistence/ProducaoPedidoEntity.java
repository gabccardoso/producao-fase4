package com.fiap.producao.infrastructure.persistence;

import com.fiap.producao.infrastructure.controllers.enums.Status;
import jakarta.persistence.*;

@Table(name = "PRODUCAO_PEDIDOS")
@Entity
public class ProducaoPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idPedido;

    @Enumerated(EnumType.STRING)
    private Status status;

    public ProducaoPedidoEntity(Long idPedido, Status status) {
        this.idPedido = idPedido;
        this.status = status;
    }

    public ProducaoPedidoEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
