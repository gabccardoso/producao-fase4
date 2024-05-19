package com.fiap.producao.infrastructure.persistence;

import com.fiap.producao.infrastructure.controllers.enums.Status;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductRepositoryTest {
    @Mock
    ProducaoPedidoRepository producaoPedidoRepository;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void devePermitirCriarOrdemDePedido(){
        ProducaoPedidoEntity producaoPedidoEntity = new ProducaoPedidoEntity(1L, Status.RECEBIDO);

        when(producaoPedidoRepository.save(any(ProducaoPedidoEntity.class))).thenReturn(producaoPedidoEntity);

        ProducaoPedidoEntity pedidoRetornado = producaoPedidoRepository.save(producaoPedidoEntity);
        //Assert
        verify(producaoPedidoRepository, times(1)).save(any(ProducaoPedidoEntity.class));
        Assertions.assertEquals(producaoPedidoEntity, pedidoRetornado);
    }

    @Test
    void devePermitirBuscarPedidoPorId(){
        ProducaoPedidoEntity pedido = new ProducaoPedidoEntity(1L, Status.RECEBIDO);
        //Arrange
        when(producaoPedidoRepository.findById(anyLong())).thenReturn(Optional.of(pedido));
        //Act
        Optional<ProducaoPedidoEntity> pedidoRetornado = producaoPedidoRepository.findById(anyLong());
        //Assert
        verify(producaoPedidoRepository, times(1)).findById(anyLong());
        Assertions.assertEquals(pedido, pedidoRetornado.get());
    }

    @Test
    void devePermitirBuscarPedidoPorIdPedido(){
        ProducaoPedidoEntity produto1 = new ProducaoPedidoEntity(1L, Status.RECEBIDO);

        //Arrange
        when(producaoPedidoRepository.findByIdPedido(anyLong())).thenReturn(produto1);
        //Act
        ProducaoPedidoEntity pedidoRetornados = producaoPedidoRepository.findByIdPedido(1L);
        //Assert
        verify(producaoPedidoRepository, times(1)).findByIdPedido(1L);
        Assertions.assertEquals(produto1, pedidoRetornados);
    }


    @Test
    void devePermitirDeletarPedido(){
        producaoPedidoRepository.deleteById(any());
        verify(producaoPedidoRepository, times(1)).deleteById(any());
    }

    @Test
    void devePermitirListarPedidos(){
        ProducaoPedidoEntity produto1 = new ProducaoPedidoEntity(1L, Status.RECEBIDO);
        ProducaoPedidoEntity produto2 = new ProducaoPedidoEntity(2L, Status.RECEBIDO);

        List<ProducaoPedidoEntity> productList = Arrays.asList(produto1, produto2);

        when(producaoPedidoRepository.findAll()).thenReturn(productList);

        List<ProducaoPedidoEntity> produtosRetornados = producaoPedidoRepository.findAll();

        verify(producaoPedidoRepository, times(1)).findAll();
        Assertions.assertEquals(productList, produtosRetornados);

    }
}
