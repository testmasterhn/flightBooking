package goquo.autotest.screenplay.questions;

import java.util.List;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ShowResult implements Question<Integer> {
    @Override
    public Integer answeredBy(Actor actor) {
    	List<WebElementFacade> resultPanel = BrowseTheWeb.as(actor).findAll(By.cssSelector("div#result"));
    	return resultPanel.size();
    }
}
