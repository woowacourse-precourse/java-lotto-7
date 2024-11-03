package lotto.domain;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Amount amount1 = (Amount)o;
		return amount == amount1.amount;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(amount);
	}

	public int getAmount() {
		return amount;
	}

	public int getQuantity() {
		return amount / DIVISIBLE_PRICE;
	}

	private void validateDivisible(int amount) {
		if (amount % DIVISIBLE_PRICE != 0) {
			throw new IllegalArgumentException(InputValidationMessage.INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
		}
	}
}
