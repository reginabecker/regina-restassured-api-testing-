package br.com.restassuredapitesting.tests.booking.request;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingRequest {
  @Step("Buscar todas as reservas.")
    public Response allBookings() {
      return given()
              .header("Content-Type", "application/json")
              .when()
              .get("booking");
  }

  @Step("Buscar uma reserva específica.")
  public Response bookingID() {
    return given()
            .header("Content-Type", "application/json")
            .when()
            .get("booking/8");
  }

  @Step("Buscar uma reserva por Firstname.")
  public Response bookingFirstName() {
    return given()
            .header("Content-Type", "application/json")
            .when()
            .get("booking?firstname=Mark");
  }

  @Step("Buscar uma reserva por Lastname.")
  public Response bookingLastName() {
    return given()
            .header("Content-Type", "application/json")
            .when()
            .get("booking?lastname=Wilson");
  }

  @Step("Buscar uma reserva por Checking.")
  public Response bookingChecking() {
    return given()
            .header("Content-Type", "application/json")
            .when()
            .get("booking?checkin=2017-11-19");
  }

  @Step("Buscar uma reserva por Checkout.")
  public Response bookingCheckout() {
    return given()
            .header("Content-Type", "application/json")
            .when()
            .get("booking?checkout=2021-02-15");
  }

  @Step("Buscar uma reserva por Checking e Checkout.")
  public Response bookingCheckinECheckout() {
    return given()
            .header("Content-Type", "application/json")
            .when()
            .get("booking?checkin=2017-11-19&checkout=2021-02-15");
  }

  @Step("Buscar uma reserva por Name, Checking e Checkout.")
  public Response bookingNameECheckinECheckout() {
    return given()
            .header("Content-Type", "application/json")
            .when()
            .get("booking?firstname=Mark&checkin=2017-11-19&checkout=2021-02-15");
  }

  @Step("Buscar uma reserva por Checkout quando filtro mal formatado.")
  public Response bookingCheckoutFiltroMalFormatado() {
    return given()
            .header("Content-Type", "application/json")
            .when()
            .get("booking?checkout=15");
  }
}
