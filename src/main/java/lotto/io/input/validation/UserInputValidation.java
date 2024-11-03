package lotto.io.input.validation;

import static lotto.common.ErrorMessage.*;

import java.util.regex.Pattern;

public class UserInputValidation {

	private static final Pattern purchasePattern = Pattern.compile("^[1-9]\\d*$");

	public void validatePurchaseAmount(String purchaseAmount) {
		if (!purchasePattern.matcher(purchaseAmount).matches()) {
			throw new IllegalArgumentException(NOT_NATURAL_NUMBER_PURCHASE_AMOUNT.getComment());
		}
	}
}
