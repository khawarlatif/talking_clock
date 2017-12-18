package talking.clock.service;

/**
 * Time service that converts time to speech form in 24h notation
 * 
 * @author kl
 *
 */
public interface TimeTranslationService {
	String convertTimeToEnglish(String time);
}
