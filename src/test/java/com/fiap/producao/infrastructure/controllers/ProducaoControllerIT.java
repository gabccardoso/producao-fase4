package com.fiap.producao.infrastructure.controllers;

import com.fiap.producao.infrastructure.controllers.dto.ProducaoPedidoDTO;
import com.fiap.producao.infrastructure.controllers.enums.Status;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.Date;

import static io.restassured.RestAssured.given;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = {"/clean.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class ProducaoControllerIT {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    @Sql(scripts = {"/clean.sql", "/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void devePermitirCriarPedidosNaProducao(){
        ProducaoPedidoDTO producaoPedidoDTO = new ProducaoPedidoDTO(2L, Status.RECEBIDO);
        given()
                .filter(new AllureRestAssured())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(producaoPedidoDTO)
                .when()
                .post("/producao/criarPedido")
                .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    @Sql(scripts = {"/clean.sql", "/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void devePermitirBuscarStatusDoPedido() {
        given()
                .filter(new AllureRestAssured())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .get("/producao/buscarStatusDoPedido/43")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    @Sql(scripts = {"/clean.sql", "/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void devePermitirAlterarStatusDoPedido() {
        given()
                .filter(new AllureRestAssured())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .queryParam("status", Status.PREPARANDO.name())
                .when()
                .put("/producao/alterarStatusDoPedido/43")
                .then()
                .statusCode(HttpStatus.OK.value());
    }
}
