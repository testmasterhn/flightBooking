package goquo.autotest.screenplay.actions;


import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.apache.http.impl.conn.tsccm.WaitingThread;
import org.apache.tools.ant.taskdefs.WaitFor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Wait;

import gherkin.events.Events;
import goquo.autotest.screenplay.tasks.SearchFlight;
import goquo.autotest.screenplay.ui.SearchFlightPage;
import io.appium.java_client.android.nativekey.PressesKey;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.HitBy;
import net.serenitybdd.screenplay.actions.HitElement;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class ChangeCity implements Interaction {
	
	String strDepartureCity="";
	String strDestinationCity="";
	
	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Click.on(SearchFlightPage.DEPARTMENT_CITY),
				Enter.theValue(this.strDepartureCity).into(SearchFlightPage.DEPARTURE_AIRPORT_NAME),
				Click.on(SearchFlightPage.DEPARTURE_FILTERED_ITEM),
				Enter.theValue(this.strDestinationCity).into(SearchFlightPage.DESTINATION_AIRPORT_NAME),
				Hit.the(Keys.ARROW_DOWN, Keys.ENTER).into(SearchFlightPage.DESTINATION_AIRPORT_NAME)
			);
	}
	
	public ChangeCity(String _departure, String _destination)
	{
		this.strDepartureCity = _departure;
		this.strDestinationCity = _destination;
	}

	public static changeCityBuilder Departure(String city) {
		return new changeCityBuilder(city);
	}
	
	public static class changeCityBuilder{
		private String departure;
		
		public changeCityBuilder(String city)
		{
			this.departure = city;
		}
		
		public Performable Destination(String destination)
		{
			return instrumented(ChangeCity.class, this.departure, destination);
		}
	}
}
