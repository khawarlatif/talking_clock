package test.talking.clock.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import talking.clock.exception.NumberRangeException;
import talking.clock.service.TimeTranslationServiceImpl;
import talking.clock.service.TimeTranslationService;

public class TimeTranslationServiceTest {
	private static String ITS = "It's";
	private static String MID_DAY = "Midday";
	private static String MID_NIGHT = "Midnight";
	private static String SPACE = " ";
	private static String TWELVE_TEN = "twelve ten";
	private static TimeTranslationService timeTranslationService;

	@BeforeClass
	public static void setup() {
		timeTranslationService = new TimeTranslationServiceImpl();
	}

	@AfterClass
	public static void teardown() {
		timeTranslationService = null;
	}

	@Test
	public void testAmTime() {
		final String time = "08:34";
		final StringBuilder timeInEng = new StringBuilder(ITS).append(SPACE).append("eight thirty four");
		assertThat(timeTranslationService.convertTimeToEnglish(time), equalTo(timeInEng.toString()));
	}

	@Test
	public void testAmTime2() {
		final String time = "8:34";
		final StringBuilder timeInEng = new StringBuilder(ITS).append(SPACE).append("eight thirty four");
		assertThat(timeTranslationService.convertTimeToEnglish(time), equalTo(timeInEng.toString()));
	}

	@Test
	public void testPmTime() {
		final String time = "18:34";
		final StringBuilder timeInEng = new StringBuilder(ITS).append(SPACE).append("eighteen thirty four");
		assertThat(timeTranslationService.convertTimeToEnglish(time), equalTo(timeInEng.toString()));
	}

	@Test
	public void testMiddayTime() {
		final String time = "12:00";
		final StringBuilder timeInEng = new StringBuilder(ITS).append(SPACE).append(MID_DAY);
		assertThat(timeTranslationService.convertTimeToEnglish(time), equalTo(timeInEng.toString()));
	}

	@Test
	public void testPastMiddayTime() {
		final String time = "12:10";
		final StringBuilder timeInEng = new StringBuilder(ITS).append(SPACE).append(TWELVE_TEN);
		assertThat(timeTranslationService.convertTimeToEnglish(time), equalTo(timeInEng.toString()));
	}

	@Test
	public void testMidnightTime() {
		final String time = "00:00";
		final StringBuilder timeInEng = new StringBuilder(ITS).append(SPACE).append(MID_NIGHT);
		assertThat(timeTranslationService.convertTimeToEnglish(time), equalTo(timeInEng.toString()));
	}

	@Test
	public void testPastMidnightTime() {
		final String time = "00:10";
		final StringBuilder timeInEng = new StringBuilder(ITS).append(SPACE).append(TWELVE_TEN);
		assertThat(timeTranslationService.convertTimeToEnglish(time), equalTo(timeInEng.toString()));
	}

	@Test(expected = NumberRangeException.class)
	public void testInvalidMins() {
		final String time = "00:60";
		timeTranslationService.convertTimeToEnglish(time);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidTime() {
		final String time = "ss:60";
		timeTranslationService.convertTimeToEnglish(time);
	}

	@Test
	public void testHourAM() {
		final String time = "11:00";
		final StringBuilder timeInEng = new StringBuilder(ITS).append(SPACE).append("eleven o clock");
		assertThat(timeTranslationService.convertTimeToEnglish(time), equalTo(timeInEng.toString()));
	}

	@Test
	public void testHourPM() {
		final String time = "18:00";
		final StringBuilder timeInEng = new StringBuilder(ITS).append(SPACE).append("eighteen o clock");
		assertThat(timeTranslationService.convertTimeToEnglish(time), equalTo(timeInEng.toString()));
	}

	@Test
	public void test15minsPast() {
		final String time = "18:15";
		final StringBuilder timeInEng = new StringBuilder(ITS).append(SPACE).append("fifteen past eighteen");
		assertThat(timeTranslationService.convertTimeToEnglish(time), equalTo(timeInEng.toString()));
	}

	@Test
	public void test30minsPast() {
		final String time = "18:30";
		final StringBuilder timeInEng = new StringBuilder(ITS).append(SPACE).append("half past eighteen");
		assertThat(timeTranslationService.convertTimeToEnglish(time), equalTo(timeInEng.toString()));
	}

	@Test
	public void test45minsPast() {
		final String time = "18:45";
		final StringBuilder timeInEng = new StringBuilder(ITS).append(SPACE).append("fifteen to nineteen");
		assertThat(timeTranslationService.convertTimeToEnglish(time), equalTo(timeInEng.toString()));
	}

	@Test
	public void test15toMidnight() {
		final String time = "23:45";
		final StringBuilder timeInEng = new StringBuilder(ITS).append(SPACE).append("fifteen to twelve");
		assertThat(timeTranslationService.convertTimeToEnglish(time), equalTo(timeInEng.toString()));
	}
}
