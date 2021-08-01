package br.com.restassuredapitesting.tests.booking.request;
import br.com.restassuredapitesting.tests.auth.requests.PostAuthRequest;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class DeleteBookingRequest {
    PostAuthRequest postAuthRequest = new PostAuthRequest();

    @Step("Excluir uma reserva com token")
    public Response excluirUmaReservaComToken(int id, JSONObject payload) {
        return given()
                .header("Cookie", postAuthRequest.getToken())
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .delete("booking/" +id);
    }

    @Step("Excluir uma reserva que não existe com token")
    public Response excluirUmaReservaQueNaoExisteComToken(int id, JSONObject payload) {
        return given()
                .header("Content-Type", "application/json")
                .header("Cookie", postAuthRequest.getToken())
                .when()
                .delete("booking/" +id);
    }

    @Step("Excluir uma reserva SEM token")
    public Response excluirUmaReservaSEMToken(int id, JSONObject payload) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .delete("booking/" +id);
    }
}
