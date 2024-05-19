package com.fiap.producao.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProducaoPedidoRepository extends JpaRepository<ProducaoPedidoEntity, Long> {

    ProducaoPedidoEntity findByIdPedido(Long idPedido);
}
