package br.com.restassuredapitesting.tests.booking.tests;
import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.request.PostBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

@Feature("Reservas")
public class PostBookingTest extends BaseTest {
    PostBookingRequest postBookingRequest = new PostBookingRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Criar uma reserva")
    public void validarCriarUmaReserva() throws Exception {

        postBookingRequest.criarUmaReserva(Utils.validPayloadBooking()).then()
                .statusCode(200)
                .time(lessThan(7L), TimeUnit.SECONDS)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Criar uma reserva quando o payload da reserva estiver inválido")
    public void validarCriarUmaReservaMalFormatado() throws Exception {

        postBookingRequest.criarUmaReservaMalFormatado(Utils.validPayloadMalFormatadoBooking()).then()
                .statusCode(500);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Criar mais de uma reserva em sequencia")
    public void validarCriarReservaEmSequencia() throws Exception {

        postBookingRequest.criarUmaReserva(Utils.validPayloadBooking()).then()
                .statusCode(200)
                .time(lessThan(7L), TimeUnit.SECONDS)
                .body("size()", greaterThan(0));

        postBookingRequest.criarUmaReserva(Utils.validPayloadBooking()).then()
                .statusCode(200)
                .time(lessThan(7L), TimeUnit.SECONDS)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Validar retorno 418 quando o header Accept for invalido")
    public void validarCriarReservaAcceptInvalido() throws Exception {

        postBookingRequest.criarUmaReservaAcceptInvalido(Utils.validPayloadBooking()).then()
                .statusCode(418);
    }
}
