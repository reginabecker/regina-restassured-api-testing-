package br.com.restassuredapitesting.runners;
import br.com.restassuredapitesting.tests.auth.tests.PostAuthTest;
//import br.com.restassuredapitesting.tests.booking.tests.GetBookingTest;
import br.com.restassuredapitesting.tests.booking.tests.DeleteBookingTest;
import br.com.restassuredapitesting.tests.booking.tests.GetBookingTest;
import br.com.restassuredapitesting.tests.booking.tests.PostBookingTest;
import br.com.restassuredapitesting.tests.booking.tests.PutBookingTest;
import br.com.restassuredapitesting.tests.healthcheck.tests.GetHealthCheckTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.restassuredapitesting.suites.Acceptance.class)
@Suite.SuiteClasses({
        DeleteBookingTest.class,
        GetBookingTest.class,
        PostBookingTest.class,
        PutBookingTest.class,
        GetHealthCheckTest.class,
        PostAuthTest.class
})
public class Acceptance {
}
