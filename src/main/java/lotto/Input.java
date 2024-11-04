package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	public int getPayment() {
		String input = Console.readLine();
		validatePayment(input);
		return Integer.parseInt(input);
	}

	public List<Integer> getLuckyNumber() {
		String input = Console.readLine();
		validateLuckyNumber(input);

		return Arrays.stream(input.split(","))
			.map(Integer::parseInt)
			.toList();
	}

	public int getBonusNumber(List<Integer> numbers) {
		String input = Console.readLine();
		validateBonusNumber(numbers, input);
		return Integer.parseInt(input);
	}

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

	public void validateBlank(String input) {
		if (input.contains(" ")) {
			throw new IllegalArgumentException("[ERROR] 입력에 공백이 포함되어 있을 수 없습니다.");
		}
	}

	public void validateSeparatorSplit(String input) {
		if (input.endsWith(",")) {
			throw new IllegalArgumentException("[ERROR] 입력은 숫자로 끝나야 합니다.");
		}
	}

	public void validateSeparator(String input) {
		for (String s : input.split(",")) {
			if (s == null || s.isEmpty()) {
				throw new IllegalArgumentException("[ERROR] 입력은 숫자, 쉼표(,) 형식으로 작성해야 합니다.");
			}
		}
	}

	public void validatePayment(String input) {
		validateEmpty(input);
		validateBlank(input);
		validateInteger(input);
		validateRemainder(input);
	}

	public void validateLuckyNumber(String input) {
		validateEmpty(input);
		validateBlank(input);
		validateSeparator(input);
		validateSeparatorSplit(input);
		validateDuplicate(input);
		validateLuckyNumberInteger(input);
		validateLuckyNumberRange(input);
		validateNumberCount(input);
	}

	public void validateBonusNumber(List<Integer> numbers, String input) {
		validateEmpty(input);
		validateInteger(input);
		validateNumberRange(Integer.parseInt(input));
		validateDuplicateBonusNumber(numbers, input);
	}
}
