package lotto;

import java.util.HashSet;
import java.util.List;

public class InputValidator {
	private static final int POSITIVE_NUMBER = 1;
	private static final int LOTTO_AMOUNT_UNIT = 1000;
	private static final int MAX_PURCHASE_AMOUNT = 100_000;
	private static final String DELIMITER = ",";
	private static final int REQUIRED_LOTTO_NUMBERS = 6;
	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;

	public static void validateNaturalNumber(String input) {
		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException("[ERROR] 값을 입력해야합니다.");
		}

		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 숫자로 입력하세요.");
		}

		if (Integer.parseInt(input) < POSITIVE_NUMBER) {
			throw new IllegalArgumentException("[ERROR] 자연수로 입력하세요.");
		}
	}

	public static void validateLottoAmountUnit(int money) {
		if (money % LOTTO_AMOUNT_UNIT != 0) {
			throw new IllegalArgumentException("[ERROR] 천원 단위로 입력해야 합니다.");
		}
	}

	public static void validateMaxPurchaseAmount(int money) {
		if (money > MAX_PURCHASE_AMOUNT) {
			throw new IllegalArgumentException("[ERROR] 최대 구매 한도는 10만원입니다.");
		}
	}

	public static void validateContainsDelimiter(String input) {
		if (!input.contains(DELIMITER)) {
			throw new IllegalArgumentException("[ERROR] 쉼표(,)를 구분자로 입력해주세요.");
		}
	}

	public static void validateSixNumbers(List<Integer> numbers) {
		if (numbers.size() != REQUIRED_LOTTO_NUMBERS) {
			throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
		}
	}

	public static void validateWinningNumbersDuplicate(List<Integer> winningNumbers) {
		if (winningNumbers.size() != new HashSet<>(winningNumbers).size()) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 포함되어 있습니다.");
		}
	}

	public static void validateNumberInLottoRange(String rawNumber) {
		validateNaturalNumber(rawNumber);
		int number = Integer.parseInt(rawNumber);

		if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
			throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45의 범위여야 합니다");
		}
	}
}
