package goquo.autotest.screenplay.actions;

import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class Focus implements Task {
	private Target target;
	@Override
    @Step("{0} Focus on #target")
    public <T extends Actor> void performAs(T theActor) {
        WebElement targetElement = target.resolveFor(theActor);
        BrowseTheWeb.as(theActor).evaluateJavascript("arguments[0].focus()", targetElement);
    }
	
	public Focus(Target target) {
        this.target = target;
    }

    public static Task on(Target target) {
        return instrumented(Focus.class, target);
    } 
}
