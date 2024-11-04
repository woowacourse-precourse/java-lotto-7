package lotto.service;

public class JudgementNumber {
	private final String REGEX_PATTERN = "^\\d+$";

	boolean judgementRange(int number) {
		return number > 0 && number < 46;
	}

	boolean judgementNumber(String number) {
		return number.matches(REGEX_PATTERN);
	}

	boolean judgementProcess(String number) {
		return judgementRange(Integer.parseInt(number))
				&& judgementNumber(number);
	}
}
