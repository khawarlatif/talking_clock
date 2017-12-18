package talking.clock;

import java.util.Scanner;

import talking.clock.service.TimeTranslationServiceImpl;
import talking.clock.service.TimeTranslationService;

public class TalkingClock {
	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
		System.out.println("Enter the time (hh:mm)");
		String sTime = in.nextLine();
		final TimeTranslationService timeTranslationService = new TimeTranslationServiceImpl();
		System.out.println(timeTranslationService.convertTimeToEnglish(sTime));
	}
}
