package goquo.autotest.screenplay.ui;

import org.openqa.selenium.By;

import com.sun.xml.bind.v2.runtime.reflect.opt.Const;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class SearchFlightPage extends PageObject {
	public static Target TICKET_TYPE_ONE_WAY = Target.the("'one-way' option").locatedBy("#loaive_o");
	public static Target TICKET_TYPE_ROUND_TRIP = Target.the("'round-trip' option").locatedBy("#loaive_r");
	public static Target DEPARTMENT_CITY = Target.the("department city").locatedBy("#departCity.city");
	public static Target DESTINATION_CITY = Target.the("Destination city").locatedBy("#returnCity.city");
	public static Target DEPARTURE_AIRPORT_NAME = Target.the("departure city").locatedBy(".sanbay .txtFlightCity");
	public static Target DESTINATION_AIRPORT_NAME = Target.the("input destination city").locatedBy(".sanbayres .txtFlightCity");
	public static Target DEPARTURE_FILTERED_ITEM = Target.the("filtered airport").locatedBy(".aircode");
	public static Target DESTINATION_FILTERED_ITEM = Target.the("destination filtered airport").locatedBy("#ui-id-2");
	
	public static Target DEPARTURE_DAY = Target.the("from").locatedBy(".dayres:not([id=\"ngayve\"]) img");
	public static Target RETURN_DAY = Target.the("from").locatedBy(".dayres[id=\"ngayve\"] img");
	public static Target CALENDAR = Target.the("calendar").locatedBy("//span[@class=\"ui-datepicker-month\"][text()=\"Tháng {0}\"]/../../..//span[@class=\"ui-datepicker-day\"][text()=\"{1}\"]/..");
	public static Target ADULTS_SELECTION = Target.the("adults selection").locatedBy("#adult");
	public static Target CHILDREN_SELECTION = Target.the("children selection").locatedBy("#child");
	public static Target INFANT_SELECTION = Target.the("infant selection").located(By.cssSelector("select[name=\"infant\"]"));

	public static Target FIND_FLIGHT = Target.the("start search flight").locatedBy("#cmdsearch");
	public static Target RESULT = Target.the("result of search").located(By.cssSelector("div#result"));
}
