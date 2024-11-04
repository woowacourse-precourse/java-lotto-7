package lotto.view;

import java.util.List;

import lotto.domain.Lotto;
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

	public void printPurchaseCountMessage(int purchaseCount) {
		System.out.println(String.format(ConsoleMessage.PURCHASE_COUNT_MESSAGE.getMessage(), purchaseCount));
	}

	public void printLottoList(List<Lotto> totalLottos) {
		for (Lotto lotto : totalLottos) {
			System.out.println(lotto.toString());
		}
	}
}
