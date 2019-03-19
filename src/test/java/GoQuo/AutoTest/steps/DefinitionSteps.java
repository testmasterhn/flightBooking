package GoQuo.AutoTest.steps;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import goquo.autotest.screenplay.questions.ShowResult;
import goquo.autotest.screenplay.tasks.SearchFlight;
import goquo.autotest.screenplay.tasks.Start;

public class DefinitionSteps {
	
	@Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }
	
	@Given("^User is staying on booking page$")
	public void user_is_staying_on_booking_page() {
		theActorCalled("anna").wasAbleTo(Start.withHomePage());
	}
	
	@When("^User book the journey with (.+) from (.+) to (.+) on (.+) to (.+) for (.+) adults and (.+) children and (.+) baby$")
    public void user_book_the_journey_with_from_to_on_to_for_adults_and_children_and_baby(String type, String departure, String destination, String from, String to, int adults, int children, int baby) throws Throwable {
		theActorInTheSpotlight().attemptsTo(
        		SearchFlight.withTrip(type)
        					.departure(departure)
        					.destination(destination)
        					.on(from)
        					.to(to)
        					.forAdult(adults)
        					.forChildren(children)
        					.forBaby(baby)
        					.BuildSearchFlight()
        );
    }

    @Then("^User should see list of flight suitable with his journey$")
    public void user_should_see_list_of_flight_suitable_with_his_journey() throws Throwable {
    	theActorInTheSpotlight().should(seeThat(new ShowResult(), equalTo(1)));
    }

}
