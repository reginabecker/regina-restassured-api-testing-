package br.com.restassuredapitesting.tests.booking.tests;
import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.request.DeleteBookingRequest;
import br.com.restassuredapitesting.tests.booking.request.GetBookingRequest;
import br.com.restassuredapitesting.tests.booking.request.PutBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;

@Feature("Reservas")
public class DeleteBookingTest extends BaseTest {
    DeleteBookingRequest deleteBookingRequest = new DeleteBookingRequest();
    GetBookingRequest getBookingRequest = new GetBookingRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Exluir uma reserva utilizado token")
    public void validarexcluirUmaReservaUtilizandoToken() throws Exception {
        int primeiroId = getBookingRequest.allBookings().then().statusCode(200).extract().path("[0].bookingid");

        deleteBookingRequest.excluirUmaReservaComToken(primeiroId, Utils.validPayloadBooking()).then()
                .statusCode(201)
                //.body("message", containsString("Created"));
                .time(lessThan(7L), TimeUnit.SECONDS);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Exluir uma reserva que não existe utilizando token")
    public void validarexcluirUmaReservaQueNaoExisteUtilizandoToken() throws Exception {
        int primeiroId = 99;

        deleteBookingRequest.excluirUmaReservaQueNaoExisteComToken(primeiroId, Utils.validPayloadBooking()).then()
                .statusCode(405)
                .time(lessThan(7L), TimeUnit.SECONDS);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Exluir uma reserva SEM token")
    public void validarexcluirUmaReservaSEMToken() throws Exception {
        int primeiroId = getBookingRequest.allBookings().then().statusCode(200).extract().path("[0].bookingid");

        deleteBookingRequest.excluirUmaReservaSEMToken(primeiroId, Utils.validPayloadBooking()).then()
                .statusCode(403)
                .time(lessThan(7L), TimeUnit.SECONDS);
    }
}

