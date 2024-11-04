package lotto.domain;

import static lotto.global.ErrorMessage.*;

public class Money {
	private static final int ZERO_MONEY = 0;

	private final int amount;

	public Money(int amount) {
		validateAmount(amount);
		this.amount = amount;
	}

	private void validateAmount(int amount) {
		if (amount <= ZERO_MONEY) {
			throw new IllegalArgumentException(MONEY_AMOUNT_ERROR.getMessage());
		}
	}

	public int getAmount(){
		return amount;
	}
}
