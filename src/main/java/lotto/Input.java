package lotto;

import java.util.Arrays;

public class Input {
	public void validateRemainder(String input) {
		if (Integer.parseInt(input) % 1000 != 0) {
			throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
		}
	}

	public void validateNumberRange(int input) {
		if (input <= 0 || input > 45) {
			throw new IllegalArgumentException("[ERROR] 번호는 1부터 45까지의 수만 입력 가능합니다.");
		}
	}

	public void validateLuckyNumberRange(String input) {
		for (String s : input.split(",")) {
			int number = Integer.parseInt(s);
			validateNumberRange(number);
		}
	}

	public void validateNumberCount(String input) {
		if (Arrays.stream(input.split(",")).count() != 6) {
			throw new IllegalArgumentException("[ERROR] 당첨번호는 6개 입력해야 합니다.");
		}
	}
}
