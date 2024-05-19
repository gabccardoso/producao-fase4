package com.fiap.producao.main;


import com.fiap.producao.application.gateways.ProducaoPedidosGateway;
import com.fiap.producao.application.useCases.ProducaoPedidoInteractor;
import com.fiap.producao.infrastructure.controllers.dto.ProducaoPedidoDTOMapper;
import com.fiap.producao.infrastructure.gateways.ProducaoPedidoEntityMapper;
import com.fiap.producao.infrastructure.gateways.ProducaoPedidoRepositoryGateway;
import com.fiap.producao.infrastructure.persistence.ProducaoPedidoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducaoConfig {

    @Bean
    ProducaoPedidoInteractor producaoPedidoInteractor(ProducaoPedidosGateway producaoPedidosGateway){
        return new ProducaoPedidoInteractor(producaoPedidosGateway);
    }

    @Bean
    ProducaoPedidosGateway producaoPedidosGateway(ProducaoPedidoRepository producaoPedidoRepository, ProducaoPedidoEntityMapper producaoPedidoEntityMapper){
        return new ProducaoPedidoRepositoryGateway(producaoPedidoRepository, producaoPedidoEntityMapper);
    }

    @Bean
    ProducaoPedidoEntityMapper producaoPedidoEntityMapper(){
        return new ProducaoPedidoEntityMapper();
    }

    @Bean
    ProducaoPedidoDTOMapper producaoPedidoDTOMapper(){
        return new ProducaoPedidoDTOMapper();
    }
}
