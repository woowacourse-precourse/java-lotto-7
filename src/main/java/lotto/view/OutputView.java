package lotto.view;

import static lotto.constants.LottoConstantNumbers.*;
import static lotto.exception.ErrorMessage.*;
import static lotto.view.ConsoleMessage.*;

import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.Prize;

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

	public void printPrizeStatistics(Map<Prize, Integer> prizeCounts) {
		StringBuilder statisticBuilder = new StringBuilder();
		statisticBuilder.append(WINNING_STATISTICS.getMessage())
			.append('\n')
			.append(DIVIDER.getMessage())
			.append('\n')
			.append(String.format(ConsoleMessage.MATCH_3.getMessage(), prizeCounts.get(Prize.FIFTH)))
			.append('\n')
			.append(String.format(ConsoleMessage.MATCH_4.getMessage(), prizeCounts.get(Prize.FOURTH)))
			.append('\n')
			.append(String.format(ConsoleMessage.MATCH_5.getMessage(), prizeCounts.get(Prize.THIRD)))
			.append('\n')
			.append(String.format(ConsoleMessage.MATCH_5_BONUS.getMessage(), prizeCounts.get(Prize.SECOND)))
			.append('\n')
			.append(String.format(ConsoleMessage.MATCH_6.getMessage(), prizeCounts.get(Prize.FIRST)))
			.append('\n');
		System.out.print(statisticBuilder);
	}

	public void printTotalYield(double yield) {
		System.out.println(String.format(TOTAL_YIELD.getMessage(), yield));
	}
}
