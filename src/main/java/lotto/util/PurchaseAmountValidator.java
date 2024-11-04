package lotto.util;

import lotto.constants.LottoConstantNumbers;
import lotto.exception.purchaseamountexception.InvalidPurchaseAmountException;
import lotto.exception.purchaseamountexception.MaxPurchaseExceedException;
import lotto.exception.purchaseamountexception.NotDivisibleByLottoPriceException;

public class PurchaseAmountValidator {

	public int validateInput(String input) {
		int parsedInput = parseStringToInt(input);
		if (isNegativeNumber(parsedInput)) {
			throw new InvalidPurchaseAmountException();
		}
		if (!canDivideWithPrice(parsedInput)) {
			throw new NotDivisibleByLottoPriceException();
		}
		if (isExceedMaxPurchaseAmount(parsedInput)) {
			throw new MaxPurchaseExceedException();
		}
		return parsedInput;
	}

	private int parseStringToInt(String input) {
		try {
			return Integer.parseInt(input);
		} catch (InvalidPurchaseAmountException e) {
			throw new InvalidPurchaseAmountException();
		}
	}

	private boolean isNegativeNumber(int purchaseAmount) {
		return purchaseAmount < 0;
	}

	private boolean canDivideWithPrice(int purchaseAmount) {
		return purchaseAmount % LottoConstantNumbers.LOTTO_PRICE.getValue() == 0;
	}

	private boolean isExceedMaxPurchaseAmount(int purchaseAmount) {
		return purchaseAmount > LottoConstantNumbers.MAX_PURCHASE_AMOUNT.getValue();
	}
}
