package lotto;

public class InputValidator {
	private static final int POSITIVE_NUMBER = 1;
	private static final int LOTTO_AMOUNT_UNIT = 1000;
	private static final int MAX_PURCHASE_AMOUNT = 100_000;

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
}
