package com.fiap.producao.infrastructure.gateways;

import com.fiap.producao.application.gateways.ProducaoPedidosGateway;
import com.fiap.producao.entities.ProducaoPedidos;
import com.fiap.producao.infrastructure.controllers.enums.Status;
import com.fiap.producao.infrastructure.persistence.ProducaoPedidoEntity;
import com.fiap.producao.infrastructure.persistence.ProducaoPedidoRepository;

public class ProducaoPedidoRepositoryGateway implements ProducaoPedidosGateway {

    private final ProducaoPedidoRepository producaoPedidoRepository;
    private final ProducaoPedidoEntityMapper producaoPedidoEntityMapper;

    public ProducaoPedidoRepositoryGateway(ProducaoPedidoRepository producaoPedidoRepository, ProducaoPedidoEntityMapper producaoPedidoEntityMapper) {
        this.producaoPedidoRepository = producaoPedidoRepository;
        this.producaoPedidoEntityMapper = producaoPedidoEntityMapper;
    }

    @Override
    public ProducaoPedidos buscarStatusDoPedido(Long pedidoId) {
        ProducaoPedidoEntity producaoPedidoEntity = producaoPedidoRepository.findByIdPedido(pedidoId);
        return producaoPedidoEntityMapper.toDomainObject(producaoPedidoEntity);
    }

    @Override
    public ProducaoPedidos alterarStatusDoPedido(Long pedidoId, Status status) {
        ProducaoPedidoEntity producaoPedidoEntity = producaoPedidoRepository.findByIdPedido(pedidoId);
        producaoPedidoEntity.setStatus(status);
        ProducaoPedidoEntity producaoPedidoEntityNovo = producaoPedidoRepository.save(producaoPedidoEntity);
        return producaoPedidoEntityMapper.toDomainObject(producaoPedidoEntityNovo);
    }

    @Override
    public ProducaoPedidos salvaPedido(ProducaoPedidos producaoPedidos){
        if(producaoPedidoRepository.findByIdPedido(producaoPedidos.idPedido()) != null){
            throw new RuntimeException("O pedido já está cadastrado na produção");
        }
        ProducaoPedidoEntity producaoPedidoEntityRecebido = producaoPedidoEntityMapper.toEntity(producaoPedidos);
        ProducaoPedidoEntity producaoPedidoEntitySalvo = producaoPedidoRepository.save(producaoPedidoEntityRecebido);
        return producaoPedidoEntityMapper.toDomainObject(producaoPedidoEntitySalvo);
    }
}
