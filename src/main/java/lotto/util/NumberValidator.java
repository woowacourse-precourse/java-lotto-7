package lotto.util;

import lotto.exception.purchaseamountexception.InvalidPurchaseAmountException;

public class NumberValidator {

	public int parseStringToInt(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new InvalidPurchaseAmountException();
		}
	}

	public boolean isNegativeNumber(int purchaseAmount) {
		return purchaseAmount < 0;
	}
}
