package com.fiap.producao.infrastructure.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import com.fiap.producao.application.useCases.ProducaoPedidoInteractor;
import com.fiap.producao.entities.ProducaoPedidos;
import com.fiap.producao.infrastructure.controllers.enums.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

public class ProducaoControllerTest {

    @InjectMocks
    private ProducaoController producaoController;

    @Mock
    private ProducaoPedidoInteractor producaoPedidoInteractor;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByOrderId() {
        ProducaoPedidos mockPedido = new ProducaoPedidos(1L, Status.RECEBIDO);
        when(producaoPedidoInteractor.buscarStatusDoPedido(anyLong())).thenReturn(mockPedido);

        ResponseEntity<String> response = producaoController.findByOrderId(1L);
        assertEquals("RECEBIDO", response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testAlterarStatusDoPedido() {
        ProducaoPedidos mockPedido = new ProducaoPedidos(1L, Status.RECEBIDO);
        when(producaoPedidoInteractor.alterarStatusDoPedido(anyLong(), any(Status.class))).thenReturn(mockPedido);

        ResponseEntity<ProducaoPedidos> response = producaoController.alterarStatusDoPedido("RECEBIDO", 1L);
        assertEquals(mockPedido, response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }
}
