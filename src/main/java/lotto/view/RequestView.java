package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.ErrorMessage;

public class RequestView {
	private static final String LOTTO_PURCHASE_AMOUNT_MESSAGE = "구매금액을 입력해 주세요.";

	public int inputBuyPrice() {
		System.out.println(LOTTO_PURCHASE_AMOUNT_MESSAGE);
		String input = Console.readLine();
		int amount = toNumber(input);
		validateAmount(amount);
		return amount;
	}

	private int toNumber(String numberAsString) {
		try {
			return Integer.parseInt(numberAsString);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_INPUT.getMessage());
		}
	}

	private void validateAmount(int amount) {
		if (amount % 1_000 != 0) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.getMessage());
		}
	}
}
