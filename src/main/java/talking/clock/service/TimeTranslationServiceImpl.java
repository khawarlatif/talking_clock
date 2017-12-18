package talking.clock.service;

import talking.clock.utils.NumberToWordsConvertor;
import talking.clock.utils.TimeValidator;

public class TimeTranslationServiceImpl implements TimeTranslationService {
	private static final String ITS = "It's";
	private static final String MID_DAY = "Midday";
	private static final String MID_NIGHT = "Midnight";
	private static final String SPACE = " ";
	private static final String O_CLOCK = "o clock";
	private static final String FIFTEEN_PAST = "fifteen past";
	private static final String HALF_PAST = "half past";
	private static final String FIFTEEN_TO = "fifteen to";
	private static final String COLLEN = ":";
	private static final String ZERO = "zero";
	private static final String TWELVE_STR = "twelve";
	private static final int TWELVE = 12;
	private static final int TWENTY_FOUR = 24;
	private static final int FIFTEEN = 15;
	private static final int THIRTY = 30;
	private static final int FORTY_FIVE = 45;

	@Override
	public String convertTimeToEnglish(String time) {
		final String stime = time.replace(SPACE, "");
		final StringBuilder result = new StringBuilder(ITS).append(SPACE);
		if (TimeValidator.validateInput(time)) {
			switch (stime) {
			case "12:00":
				result.append(MID_DAY);
				break;
			case "00:00":
				result.append(MID_NIGHT);
				break;
			default:
				result.append(translateHoursAndMins(stime));
				break;
			}
		} else {
			throw new IllegalArgumentException("Invalid entry - please a valid time entry");
		}
		return result.toString();
	}

	private StringBuilder translateHoursAndMins(String time) {
		final String[] hourMins = time.split(COLLEN);
		int hours = Integer.parseInt(hourMins[0]);
		final int mins = Integer.parseInt(hourMins[1]);
		final StringBuilder sb = new StringBuilder();
		final String hourTranslation = getHourTranslation(hours);
		switch (mins) {
		case FIFTEEN:
			sb.append(FIFTEEN_PAST).append(SPACE).append(hourTranslation);
			break;
		case THIRTY:
			sb.append(HALF_PAST).append(SPACE).append(hourTranslation);
			break;
		case FORTY_FIVE:
			sb.append(FIFTEEN_TO).append(SPACE).append(getHourTranslation(++hours));
			break;
		default:
			final String minsTranslation = getMinsTranslation(mins);
			sb.append(hourTranslation).append(SPACE).append(minsTranslation);
			break;
		}
		return sb;
	}

	private String getHourTranslation(int num) {
		// in case the time is 23:45
		final int hour = (num == TWENTY_FOUR) ? TWELVE : num;
		final String translation = NumberToWordsConvertor.convertToWords(hour);
		return translation.equals(ZERO) ? TWELVE_STR : translation;
	}

	private String getMinsTranslation(int num) {
		final String translation = NumberToWordsConvertor.convertToWords(num);
		return translation.equals(ZERO) ? O_CLOCK : translation;
	}
}
