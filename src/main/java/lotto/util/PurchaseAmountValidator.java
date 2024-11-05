package lotto.util;

import lotto.constants.LottoConstantNumbers;
import lotto.exception.purchaseamountexception.InvalidPurchaseAmountException;
import lotto.exception.purchaseamountexception.MaxPurchaseExceedException;
import lotto.exception.purchaseamountexception.NotDivisibleByLottoPriceException;

public class PurchaseAmountValidator {

	private final NumberValidator numberValidator;

	public PurchaseAmountValidator(NumberValidator numberValidator) {
		this.numberValidator = numberValidator;
	}

	public int validateInput(String input) {
		int parsedInput = numberValidator.parseStringToInt(input);
		if (numberValidator.isNegativeNumber(parsedInput)) {
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

	private boolean canDivideWithPrice(int purchaseAmount) {
		return purchaseAmount % LottoConstantNumbers.LOTTO_PRICE.getValue() == 0;
	}

	private boolean isExceedMaxPurchaseAmount(int purchaseAmount) {
		return purchaseAmount > LottoConstantNumbers.MAX_PURCHASE_AMOUNT.getValue();
	}
}
