package lotto.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
	public static int validateInteger(String input) {
		try {
			int parsedInput = Integer.parseInt(input);
			return parsedInput;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 입력한 값이 정수가 아닙니다. 숫자를 입력해 주세요.");
		}
	}

	public static List<Integer> validateWinningNumbers(String input) {
		try {
			List<Integer> numbers = Arrays.stream(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
			return numbers;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.");
		}
	}
}
