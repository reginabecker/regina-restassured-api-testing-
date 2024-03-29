package br.com.restassuredapitesting.tests.healthcheck.requests;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetHealthCheckRequest {
    @Step("Verificar se API está online")
    public Response healthCheck() {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("ping");
    }
}