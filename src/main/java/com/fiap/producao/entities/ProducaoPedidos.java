package com.fiap.producao.entities;


import com.fiap.producao.infrastructure.controllers.enums.Status;

public record ProducaoPedidos(Long idPedido, Status status){}
