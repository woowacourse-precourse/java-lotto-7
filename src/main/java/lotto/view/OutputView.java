package lotto.view;

import static lotto.constants.LottoConstantNumbers.*;
import static lotto.exception.ErrorMessage.*;
import static lotto.view.ConsoleMessage.*;

import java.util.List;

import lotto.domain.Lotto;

public class OutputView {

	public void printPurchaseAmountMessage() {
		System.out.println(INPUT_PURCHASE_AMOUNT.getMessage());
	}

	public void printInvalidPurchaseAmountMessage() {
		System.out.println(INVALID_PURCHASE_AMOUNT.getMessage());
	}

	public void printNotDivisibleByLottoPriceMessage() {
		System.out.println(NOT_DIVISIBLE_BY_LOTTO_PRICE.getMessage());
	}

	public void printMaxPurchaseExceedMessage() {
		System.out.println(MAX_PURCHASE_EXCEED.getMessage());
	}

	public void printInvalidLottoNumberSizeMessage() {
		System.out.println(String.format(INVALID_LOTTO_NUMBERS_COUNT.getMessage(), LOTTO_NUMBERS_COUNT));
	}

	public void printPurchaseCountMessage(int purchaseCount) {
		System.out.println(String.format(PURCHASE_COUNT_MESSAGE.getMessage(), purchaseCount));
	}

	public void printOutOfRangeNumberMessage() {
		System.out.println(String.format(OUT_OF_RANGE_NUMBER.getMessage(), MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
	}

	public void printToGetWinningNumbers() {
		System.out.println(INPUT_WINNING_NUMBERS.getMessage());
	}

	public void printDuplicateNumberMessage() {
		System.out.println(DUPLICATE_NUMBER.getMessage());
	}

	public void printToGetBonusNumbers() {
		System.out.println(INPUT_BONUS_NUMBER.getMessage());
	}

	public void printLottoList(List<Lotto> totalLottos) {
		for (Lotto lotto : totalLottos) {
			System.out.println(lotto.toString());
		}
	}
}
