package br.com.restassuredapitesting.tests.booking.tests;
import br.com.restassuredapitesting.suites.Acceptance;
import br.com.restassuredapitesting.suites.Contract;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.request.GetBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import java.io.File;
import java.util.concurrent.TimeUnit;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

@Feature("Reservas")
public class GetBookingTest extends BaseTest {
    GetBookingRequest getBookingRequest = new GetBookingRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar IDs das Reservas")
    public void validarIdsDasReservas() throws Exception {
        getBookingRequest.allBookings().then()
                .statusCode(200)
                .time(lessThan(7L), TimeUnit.SECONDS)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category(Contract.class)
    @DisplayName("Garantir o contrato do retorno da Lista de reservas")
    public void garantirContratoListaReserva() throws Exception {
        getBookingRequest.allBookings().then()
                .statusCode(200)
                .assertThat()
                .body(
                   matchesJsonSchema(
                       new File(
                             Utils.getContractsBasePath("booking", "bookings")
                        )
                    )
                );
    }

///////////////////////// SUITE CONTRACT ////////////////////////////////
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar uma Reserva específica")
    public void validarIdDaReservaEspecifica() throws Exception {
        getBookingRequest.bookingID().then()
                .statusCode(200)
                .time(lessThan(7L), TimeUnit.SECONDS)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category(Contract.class)
    @DisplayName("Garantir o contrato do retorno de uma reserva específica")
    public void garantirContratoListaReservaEspecifica() throws Exception {
        getBookingRequest.bookingID().then()
                .statusCode(200)
                .assertThat()
                .body(
                        matchesJsonSchema(
                                new File(
                                        Utils.getContractsBasePath("booking", "bookingID")
                                )
                        )
                );
    }

///////////////////////// SUITE ACCEPTANCE ////////////////////////////////
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar uma Reserva por Firstname")
    public void validarFirstNameDaReserva() throws Exception {
        getBookingRequest.bookingFirstName().then()
                .statusCode(200)
                .time(lessThan(7L), TimeUnit.SECONDS)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar uma Reserva por Lastname")
    public void validarLastNameDaReserva() throws Exception {
        getBookingRequest.bookingLastName().then()
                .statusCode(200)
                .time(lessThan(7L), TimeUnit.SECONDS)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar uma Reserva por Checking")
    public void validarCheckingDaReserva() throws Exception {
        getBookingRequest.bookingChecking().then()
                .statusCode(200)
                .time(lessThan(7L), TimeUnit.SECONDS)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar uma Reserva por Checkout")
    public void validarCheckoutDaReserva() throws Exception {
        getBookingRequest.bookingCheckout().then()
                .statusCode(200)
                .time(lessThan(7L), TimeUnit.SECONDS)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar uma Reserva por Checking e Checkout")
    public void validarCheckoutECheckoutDaReserva() throws Exception {
        getBookingRequest.bookingCheckinECheckout().then()
                .statusCode(200)
                .time(lessThan(7L), TimeUnit.SECONDS)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar uma Reserva por Name, Checking e Checkout")
    public void validarNameECheckinECheckoutDaReserva() throws Exception {
        getBookingRequest.bookingNameECheckinECheckout().then()
                .statusCode(200)
                .time(lessThan(7L), TimeUnit.SECONDS)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar uma Reserva por Checkout quando filtro mal formatado")
    public void validarCheckoutDaReservaFiltroMalFormatado() throws Exception {
        getBookingRequest.bookingCheckoutFiltroMalFormatado().then()
                .statusCode(500)
                .time(lessThan(7L), TimeUnit.SECONDS);
    }
}





