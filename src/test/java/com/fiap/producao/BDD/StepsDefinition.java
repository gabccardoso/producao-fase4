package com.fiap.producao.BDD;


import com.fiap.producao.infrastructure.controllers.dto.ProducaoPedidoDTO;
import com.fiap.producao.infrastructure.controllers.enums.Status;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import static io.restassured.RestAssured.given;

public class StepsDefinition {

    private Response response;
    private final String ENDIPOINT_API_ORDER = "http://localhost:5522/producao";

    @Quando("registrar um novo pedido")
    public void registrar_um_novo_pedido(Long idPedido) {
        Long id = idPedido != null ? idPedido : 13L;
        ProducaoPedidoDTO producaoPedidoDTO = new ProducaoPedidoDTO(id, Status.RECEBIDO);
        response = given()
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .body(producaoPedidoDTO)
                    .when()
                    .post(ENDIPOINT_API_ORDER + "/criarPedido");
    }

    @Entao("o pedido é registrado com sucesso")
    public void o_pedido_é_registrado_com_sucesso() {
        response.then().statusCode(HttpStatus.CREATED.value());
    }

    @Dado("que já existe um pedido na produção")
    public void que_já_existe_um_pedido_na_produção() {
        Long idPedido = 37L;
        registrar_um_novo_pedido(idPedido);
    }

    @Quando("buscar esse pedido")
    public void buscar_esse_pedido() {
        response = given()
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .when()
                    .get(ENDIPOINT_API_ORDER + "/buscarStatusDoPedido/37");
    }
    @Entao("o pedido retorna com sucesso")
    public void o_pedido_retorna_com_sucesso() {
        response.then().statusCode(200);
    }

    @Dado("que já existe um pedido")
    public void que_já_existe_um_pedido() {
        registrar_um_novo_pedido(9L);
    }
    @Quando("alterar status do pedido")
    public void alterar_status_do_pedido() {
        response = given()
                .filter(new AllureRestAssured())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .queryParam("status", Status.PREPARANDO.name())
                .when()
                .put( ENDIPOINT_API_ORDER + "/alterarStatusDoPedido/9");
    }

}
