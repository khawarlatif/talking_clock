package talking.clock.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeValidator {
	/**
	 * Validate the input
	 * 
	 * @param time
	 * @return
	 */
	public static boolean validateInput(String time) {
		Pattern p = Pattern.compile("\\d{1,2}:\\d{1,2}");
		Matcher m = p.matcher(time);
		return m.matches();
	}
}
