package br.com.restassuredapitesting.tests.booking.request;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class PostBookingRequest {
    @Step("Criar uma reserva")
    public Response criarUmaReserva(JSONObject payload) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(Utils.validPayloadBooking().toString())
                .post("booking");
    }

    @Step("Criar uma reserva quando o payload da reserva estiver inválido")
    public Response criarUmaReservaMalFormatado(JSONObject payloadBad) {
        return given()
                .header("Content-Type", "application/json")
                .when()
                .body(payloadBad.toString())
                .post("booking");
    }

    @Step("Validar retorno 418 quando o Accept for invalido")
    public Response criarUmaReservaAcceptInvalido(JSONObject payload) {
        return given()
                .header("accept", "application/javascript")
                .header("Content-Type", "application/json")
                .when()
                .body(Utils.validPayloadBooking().toString())
                .post("booking");
    }
}
