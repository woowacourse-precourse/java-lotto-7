package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	public void validateLuckyNumberInteger(String input) {
		if (Arrays.stream(input.split(","))
			.anyMatch(s -> !Character.isDigit(s.charAt(0)))) {
			throw new IllegalArgumentException("[ERROR] 당첨번호 입력은 숫자만 가능합니다.");
		}
	}

	public void validateInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 입력은 숫자만 가능합니다.");
		}
	}

	public void validateDuplicate(String input) {
		Set<String> numbers = new HashSet<>();
		for (String s : input.split(",")) {
			if (!numbers.add(s)) {
				throw new IllegalArgumentException("[ERROR] 당첨번호에 중복이 있을 수 없습니다.");
			}
		}
	}

	public void validateDuplicateBonusNumber(List<Integer> numbers, String input) {
		if (numbers.contains(Integer.parseInt(input))) {
			throw new IllegalArgumentException("[ERROR] 보너스번호와 당첨번호가 중복될 수 없습니다.");
		}
	}

	public void validateEmpty(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("[ERROR] 입력이 비어있을 수 없습니다.");
		}
	}
}
