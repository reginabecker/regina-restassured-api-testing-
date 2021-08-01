package br.com.restassuredapitesting.tests.auth.requests;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;

public class PostAuthRequest {

    @Step("Buscar o token")
    //O retorno deste método é o Status o Body, o valor do Token, etc tudo
    public Response token() {
        //Criar o Objeto Json do Body
        JSONObject payload = new JSONObject();
        payload.put("username", "admin");
        payload.put("password", "password123");

        return given()
                //.header("Content-Type","application/json")
                .contentType("application/json")
                .when()
                .body(payload.toString())
                .post("auth");
    }

    //Este método auxiliar é só para retornar o valor do Token
    @Step("Retornar o token")
    public String getToken() {

        //Extraindo do retorno do body só o conteúdo do path(atributo) token
        return "token="+this.token().then().statusCode(200).extract().path("token");
    }
}
