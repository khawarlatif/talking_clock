package talking.clock.utils;

import talking.clock.exception.NumberRangeException;

/**
 * Utils class that translate number (0-59) to English form
 * 
 * @author kl
 *
 */
public class NumberToWordsConvertor {
	private static final int TEN = 10;
	private static final String SPACE = " ";
	private static String EMPTY = "";
	private static final String[] ONES = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine" };
	private static final String[] TEENS = { EMPTY, "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
			"seventeen", "eighteen", "nineteen" };
	private static final String[] TENS = { EMPTY, "ten", "twenty", "thirty", "fourty", "fifty" };

	// so it can not be instantiated
	private NumberToWordsConvertor() {
	}

	/**
	 * Convert number to words
	 * 
	 * @param number
	 * @return
	 */
	public static String convertToWords(int number) {
		final StringBuilder result = new StringBuilder();
		final int sixty = 60;
		if (number < 0 || number >= sixty) {
			throw new NumberRangeException("Number out of range (0 - 59)");
		} else if (number < TEN) {
			result.append(ONES[number]);
		} else {
			result.append(translateTwoDigitNumber(number));
		}
		return result.toString();
	}

	/**
	 * Translate 2 digit number i.e. > 9
	 * 
	 * @param number
	 * @return
	 */
	private static StringBuilder translateTwoDigitNumber(int number) {
		final StringBuilder result = new StringBuilder();
		final int remainder = number % TEN;
		final int leftMostDigit = number / TEN;
		final int one = 1;
		final int zero = 0;

		if (leftMostDigit == one) {
			result.append((remainder == zero) ? TENS[one] : TEENS[remainder]);
		} else {
			result.append(TENS[leftMostDigit]).append(SPACE);
			// if divisible by 10 do not append anything
			result.append((remainder != zero) ? ONES[remainder] : "");
		}
		return result;
	}
}
