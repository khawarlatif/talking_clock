package test.talking.clock;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import talking.clock.exception.NumberRangeException;
import talking.clock.utils.NumberToWordsConvertor;

public class NumberToWordsConvertorTest {
	@Test
	public void testSingleDigitConversion() {
		final String wordForm = "two";
		final int number = 2;
		assertThat(NumberToWordsConvertor.convertToWords(number), equalTo(wordForm));
	}

	@Test
	public void testTeenDigitConversion() {
		final String wordForm = "thirteen";
		final int number = 13;
		assertThat(NumberToWordsConvertor.convertToWords(number), equalTo(wordForm));
	}

	@Test
	public void testDoubleDigitConversion() {
		final String wordForm = "twenty two";
		final int number = 22;
		assertThat(NumberToWordsConvertor.convertToWords(number), equalTo(wordForm));
	}

	/**
	 * Test case for coversion like 01 should be one
	 */
	@Test
	public void testSingleDigitWithZeroConversion() {
		final String wordForm = "two";
		final int number = 02;
		assertThat(NumberToWordsConvertor.convertToWords(number), equalTo(wordForm));
	}

	@Test(expected = NumberRangeException.class)
	public void testOutOfUpperRangeConversion() throws NumberRangeException {
		final int number = 60;
		NumberToWordsConvertor.convertToWords(number);
	}

	@Test(expected = NumberRangeException.class)
	public void testOutOfLowerRangeConversion() throws NumberRangeException {
		final int number = -1;
		NumberToWordsConvertor.convertToWords(number);
	}
}
