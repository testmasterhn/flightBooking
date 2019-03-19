package goquo.autotest.screenplay.actions;

import java.util.*;

import goquo.autotest.screenplay.ui.SearchFlightPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class SelectDate implements Task {
	private Target target;
	private Date date;
	private int month;
	private int day;

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(this.target),
				Click.on(SearchFlightPage.CALENDAR.of(String.valueOf(this.month), String.valueOf(this.day))));
	}

	public SelectDate(Target target, Date value) {
		this.target = target;
		this.date = value;
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.date);
		this.month = cal.get(Calendar.MONTH)+1;
		this.day = cal.get(Calendar.DAY_OF_MONTH);
	}

	public static Task on(Target target, Date value) {
		return instrumented(SelectDate.class, target, value);
	}
}
