package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	// 지불금액 입력받는 함수
	public static void getPayment() {
		String input = Console.readLine();
		validatePayment(input);
	}

	// 당첨번호 입력받는 함수
	public static List<Integer> getLuckyNumber() {
		String input = Console.readLine();
		validateLuckyNumber(input);

	    return Arrays.stream(input.split(","))
			.map(Integer::parseInt)
			.toList();
	}

	// 보너스번호 입력받는 함수
	public static void getBonusNumber(List<Integer> numbers) {
		String input = Console.readLine();
		validateBonusNumber(numbers, input);
	}

	// 입력한 지불금액이 1000으로 나눴을때 0으로 떨어지는지 확인하는 함수
	public static void validateRemainder(String input) {
		if (Integer.parseInt(input) % 1000 != 0) {
			throw new IllegalArgumentException("구입 금액은 1000원 단위로 입력해야 합니다.");
		}
	}

	// 당첨번호가 1-45까지의 입력인지 확인하는 함수
	public static void validateLuckyNumberRange(String input) {
		for (String s : input.split(",")) {
			int number = Integer.parseInt(s);
			validateNumberRange(number);
		}
	}

	// 번호가 1-45까지의 입력인지 확인하는 함수
	public static void validateNumberRange(int input) {
		if (input <= 0 || input > 45) {
			throw new IllegalArgumentException("번호는 1부터 45까지의 수만 입력 가능합니다.");
		}
	}

	// 당첨번호 입력이 6개인지 확인하는 함수
	public static void validateNumberCount(String input) {
		if (Arrays.stream(input.split(",")).count() != 6) {
			throw new IllegalArgumentException("당첨번호는 6개 입력해야 합니다.");
		}
	}

	// 당첨번호가 숫자인지 확인하는 함수
	public static void validateLuckyNumberInteger(String input) {
		if (Arrays.stream(input.split(","))
			.anyMatch(s -> !Character.isDigit(s.charAt(0)))) {
			throw new IllegalArgumentException("당첨번호 입력은 숫자만 가능합니다.");
		}
	}

	// 입력이 숫자인지 확인하는 함수
	public static void validateInteger(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("입력은 숫자만 가능합니다.");
		}
	}

	// 당첨번호 입력에 중복이 존재하는지 확인하는 함수
	public static void validateDuplicate(String input) {
		Set<String> numbers = new HashSet<>();
		for (String s : input.split(",")) {
			if (!numbers.add(s)) {
				throw new IllegalArgumentException("당첨번호에 중복이 있을 수 없습니다.");
			}
		}
	}

	// 보너스번호가 당첨번호 중에 존재하는지 확인하는 함수
	public static void validateDuplicateBonusNumber(List<Integer> numbers, String input) {
		if (numbers.contains(Integer.parseInt(input))) {
			throw new IllegalArgumentException("보너스번호와 당첨번호가 중복될 수 없습니다.");
		}
	}

	// 입력이 빈 문자열인지 확인하는 함수
	public static void validateEmpty(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("입력이 비어있을 수 없습니다.");
		}
	}

	// 당첨번호 입력에 공백이 존재하는지 확인하는 함수
	public static void validateBlank(String input) {
		if (input.contains(" ")) {
			throw new IllegalArgumentException("입력에 공백이 포함되어 있을 수 없습니다.");
		}
	}

	// 당첨번호 입력이 숫자로 끝나는지 확인하는 함수
	public static void validateSeparatorSplit(String input) {
		if (input.endsWith(",")) {
			throw new IllegalArgumentException("입력은 숫자로 끝나야 합니다.");
		}
	}

	// 당첨번호 앞뒤에 쉼표가 존재하는지 확인하는 함수
	public static void validateSeparator(String input) {
		for (String s : input.split(",")) {
			if (s == null || s.isEmpty()) {
				throw new IllegalArgumentException("입력은 숫자, 쉼표(,) 형식으로 작성해야 합니다.");
			}
		}
	}

	// 지불금액 입력 검증 함수
	public static void validatePayment(String input) {
		validateEmpty(input);
		validateInteger(input);
		validateRemainder(input);
	}

	// 당첨번호 입력 검증 함수
	public static void validateLuckyNumber(String input) {
		validateEmpty(input);
		validateBlank(input);
		validateSeparator(input);
		validateSeparatorSplit(input);
		validateDuplicate(input);
		validateLuckyNumberInteger(input);
		validateLuckyNumberRange(input);
		validateNumberCount(input);
	}

	// 보너스번호 입력 검증 함수
	public static void validateBonusNumber(List<Integer> numbers, String input) {
		validateEmpty(input);
		validateInteger(input);
		validateNumberRange(Integer.parseInt(input));
		validateDuplicateBonusNumber(numbers, input);
	}

	public static void main(String[] args) {
		getPayment();
		List<Integer> numbers = getLuckyNumber();
		getBonusNumber(numbers);
	}
}
