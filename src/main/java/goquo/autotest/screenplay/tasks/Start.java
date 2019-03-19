package goquo.autotest.screenplay.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import goquo.autotest.screenplay.ui.ApplicationHomePage;
import goquo.autotest.screenplay.ui.SearchFlightPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class Start implements Task {
	private ApplicationHomePage applicationHomePage;
	@Override
	@Step
	public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(applicationHomePage));
    }

    public static Start withHomePage() {
        return instrumented(Start.class);
    }

}
