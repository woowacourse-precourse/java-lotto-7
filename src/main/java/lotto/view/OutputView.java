package lotto.view;

import lotto.exception.ErrorMessage;

public class OutputView {

	public void printPurchaseAmountMessage() {
		System.out.println(ConsoleMessage.INPUT_PURCHASE_AMOUNT.getMessage());
	}

	public void printInvalidPurchaseAmountMessage() {
		System.out.println(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
	}

	public void printNotDivisibleByLottoPriceMessage() {
		System.out.println(ErrorMessage.NOT_DIVISIBLE_BY_LOTTO_PRICE.getMessage());
	}

	public void printMaxPurchaseExceedMessage() {
		System.out.println(ErrorMessage.MAX_PURCHASE_EXCEED.getMessage());
	}

}
