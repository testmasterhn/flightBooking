package goquo.autotest.screenplay.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import goquo.autotest.screenplay.actions.ChangeCity;
import goquo.autotest.screenplay.actions.SelectDate;
import goquo.autotest.screenplay.ui.SearchFlightPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

public class SearchFlight implements Task {
	boolean IsRoundTrip=false;
	String Departure = "";
	String Destination="";
	Date From = new Date();
	Date To = new Date();
	int Adults = 0;
	int Children = 0;
	int Baby = 0;
	
	public SearchFlight(boolean isRoundTrip, String departure, String destination, Date from, Date to, int adults,
			int children, int baby)
	{
		this.IsRoundTrip = isRoundTrip;
		this.Departure = departure;
		this.Destination = destination;
		this.From = from;
		this.To = to;
		this.Adults = adults;
		this.Children = children;
		this.Baby = baby;
	}
	
	public static SearchFlyBuilder withTrip(String tripType)
	{
		return new SearchFlyBuilder(tripType);
	}
	
	@Override
    @Step
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		actor.attemptsTo(
				Check.whether(this.IsRoundTrip).andIfSo(Click.on(SearchFlightPage.TICKET_TYPE_ROUND_TRIP)).otherwise(Click.on(SearchFlightPage.TICKET_TYPE_ONE_WAY)),
				ChangeCity.Departure(this.Departure).Destination(this.Destination),
				SelectDate.on(SearchFlightPage.DEPARTURE_DAY, this.From),
				SelectDate.on(SearchFlightPage.RETURN_DAY, this.To),
				SelectFromOptions.byValue(String.valueOf(this.Adults)).from(SearchFlightPage.ADULTS_SELECTION),
				SelectFromOptions.byValue(String.valueOf(this.Children)).from(SearchFlightPage.CHILDREN_SELECTION),
				SelectFromOptions.byValue(String.valueOf(this.Baby)).from(SearchFlightPage.INFANT_SELECTION),
				Click.on(SearchFlightPage.FIND_FLIGHT)
			);
	}
	
	public static SearchFlight doTheSearch() {
        return instrumented(SearchFlight.class);
    }
	
	public static class SearchFlyBuilder
	{
		boolean IsRoundTrip=false;
		String Departure = "";
		String Destination="";
		Date From = new Date();
		Date To = new Date();
		int Adults = 0;
		int Children = 0;
		int Baby = 0;
		
		public SearchFlyBuilder(String type) {
			this.IsRoundTrip = type.equalsIgnoreCase("round-trip");
		}
		
		public Task BuildSearchFlight()
		{
			return instrumented(SearchFlight.class, 
					this.IsRoundTrip,
					this.Departure,
					this.Destination,
					this.From, 
					this.To,
					this.Adults,
					this.Children,
					this.Baby
					);
		}
		
		public SearchFlyBuilder flightType(String type)
		{
			this.IsRoundTrip = type.equalsIgnoreCase("round-trip");
			return this;
		}
		
		public SearchFlyBuilder departure(String departure)
		{
			this.Departure = departure;
			return this;
		}
		
		public SearchFlyBuilder destination(String destination)
		{
			this.Destination = destination;
			return this;
		}
		
		public SearchFlyBuilder on(String from)
		{
			SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
			try {
				this.From = ft.parse(from);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return this;
		}
		
		public SearchFlyBuilder to(String to)
		{
			SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
			try {
				this.To = ft.parse(to);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return this;
		}
		
		public SearchFlyBuilder forAdult(int adults)
		{
			this.Adults = adults;
			return this;
		}
		
		public SearchFlyBuilder forChildren(int children)
		{
			this.Children = children;
			return this;
		}
		
		public SearchFlyBuilder forBaby(int baby)
		{
			this.Baby = baby;
			return this;
		}
	}
}
