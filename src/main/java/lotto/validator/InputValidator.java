package lotto.validator;

public class InputValidator {
	public static void validateInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 입력한 값이 정수가 아닙니다. 숫자를 입력해 주세요.");
		}
	}
}
