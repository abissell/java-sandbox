import junit.framework.Assert;
import org.joda.time.Chronology;
import org.joda.time.MutableDateTime;
import org.joda.time.chrono.ISOChronology;
import org.junit.Test;

public class TestSimpleTechniques {
	public TestSimpleTechniques() {

	}

	@Test
	public void testMutableJodaTime() {
		final Chronology chronology = ISOChronology.getInstance();
		final MutableDateTime dateTime = new MutableDateTime(System.currentTimeMillis(), chronology);

		System.out.println(dateTime);
		System.out.println(dateTime.getYear() + " " + dateTime.getMonthOfYear() + " " + dateTime.getDayOfMonth() + " " +
				dateTime.getHourOfDay() + " " + dateTime.getMinuteOfHour() + " " + dateTime.getSecondOfMinute() + " " + dateTime.getMillisOfSecond());


		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

		}

		dateTime.setTime(System.currentTimeMillis());
		System.out.println(dateTime);
		System.out.println(dateTime.getYear() + " " + dateTime.getMonthOfYear() + " " + dateTime.getDayOfMonth() + " " +
				dateTime.getHourOfDay() + " " + dateTime.getMinuteOfHour() + " " + dateTime.getSecondOfMinute() + " " + dateTime.getMillisOfSecond());
	}

	@Test
	public void testExpressionTricks() {
		int length = 5;
		int newLength = (length = 0);
		Assert.assertEquals(newLength, 0);
	}
}
