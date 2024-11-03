package lotto.domain;

import lotto.validator.InputValidationMessage;

public class Amount {
	private static final int DIVISIBLE_PRICE = 1000;
	private final int amount;

	private Amount(int amount) {
		validateDivisible(amount);
		this.amount = amount;
	}

	public static Amount of(int amount) {
		return new Amount(amount);
	}

	private void validateDivisible(int amount) {
		if (amount % DIVISIBLE_PRICE != 0) {
			throw new IllegalArgumentException(InputValidationMessage.INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
		}
	}

	public int getAmount() {
		return amount;
	}

	public int getQuantity() {
		return amount / DIVISIBLE_PRICE;
	}
}
