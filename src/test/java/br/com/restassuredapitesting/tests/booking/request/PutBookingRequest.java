package br.com.restassuredapitesting.tests.booking.request;
import br.com.restassuredapitesting.tests.auth.requests.PostAuthRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;

public class PutBookingRequest {
    PostAuthRequest postAuthRequest = new PostAuthRequest();

    @Step("Alterar uma reserva com token")
    public Response alterarUmaReservaComToken(int id, JSONObject payload) {
        return given()
                .header("Cookie", postAuthRequest.getToken())
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .body(Utils.validPayloadBooking().toString())
                .put("booking/" + id);
    }

    @Step("Alterar uma reserva com Basic")
    public Response alterarUmaReservaComBasicAuth(int id) {
        return given()
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .body(Utils.validPayloadBooking().toString())
                .put("booking/" + id);
    }

    @Step("Tentar alterar uma reserva quando o token não for enviado")
    public Response alterarUmaReservaSemEnvioToken(int id, JSONObject payload) {
        return given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .body(Utils.validPayloadBooking().toString())
                .put("booking/" + id);
    }

    @Step("Tentar alterar uma reserva quando o token enviado for inválido")
    public Response alterarUmaReservaTokenInvalido(int id, JSONObject payload) {
        return given()
                .header("Cookie", "token=e3dd03007faaa5f")
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .body(Utils.validPayloadBooking().toString())
                .put("booking/" + id);
    }

    @Step("Tentar alterar uma reserva que não existe")
    public Response alterarUmaReservaInexistenteComToken(int id, JSONObject payload) {
        return given()
                .header("Cookie", postAuthRequest.getToken())
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .body(Utils.validPayloadBooking().toString())
                .put("booking/" + 999);
    }
}
