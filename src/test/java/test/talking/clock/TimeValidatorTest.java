package test.talking.clock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import talking.clock.utils.TimeValidator;

public class TimeValidatorTest {
	@Test
	public void testValidInput24H() {
		final String time = "16:48";
		assertTrue("Valid input " + time, TimeValidator.validateInput(time));
	}

	@Test
	public void testValidInput24HTwo() {
		final String time = "08:08";
		assertTrue("Valid input " + time, TimeValidator.validateInput(time));
	}

	@Test
	public void testValidInput12H() {
		final String time = "6:48";
		assertTrue("Valid input " + time, TimeValidator.validateInput(time));
	}

	@Test
	public void testInValidInputWrongHours() {
		final String time = "111:48";
		assertFalse("InValid input " + time, TimeValidator.validateInput(time));
	}

	@Test
	public void testInValidInputWrongMins() {
		final String time = "11:148";
		assertFalse("InValid input " + time, TimeValidator.validateInput(time));
	}

	@Test
	public void testInValidInputNoDigit() {
		final String time = "ss:ss";
		assertFalse("InValid input " + time, TimeValidator.validateInput(time));
	}

	@Test
	public void testInValidInputDigitMixedWithString() {
		final String time = "6s:6s";
		assertFalse("InValid input " + time, TimeValidator.validateInput(time));
	}

	@Test
	public void testInValidInputMissingCollen() {
		final String time = "0606";
		assertFalse("InValid input " + time, TimeValidator.validateInput(time));
	}
}
