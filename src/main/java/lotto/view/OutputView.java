package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

import lotto.model.PurchasedLottoResultDto;
import lotto.model.PurchasedLottoResultsDto;
import lotto.model.WinningResultDto;
import lotto.model.WinningResultsDto;

public class OutputView {

	private static final String PURCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String WINNING_LOTTO_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
	private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
	private static final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---\n";
	private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.\n";
	private static final String NEW_LINE = "\n";
	private static final String DELIMITER = ", ";
	private static final String PURCHASE_LOTTO_RESULT_PREFIX = "[";
	private static final String PURCHASE_LOTTO_RESULT_SUFFIX = "]";
	private static final String DECIMAL_FORMAT = "#,###.#";

	public void printPurchasePriceInputMessage() {
		System.out.println(PURCHASE_PRICE_INPUT_MESSAGE);
	}

	public void printErrorMessage(String errorMessage) {
		System.out.println(errorMessage);
	}

	public void printPurchasedLottoResultMessage(int count, PurchasedLottoResultsDto purchasedLottoResults) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(NEW_LINE);
		stringBuilder.append(getLottoCountMessage(count));
		for (PurchasedLottoResultDto purchasedLottoResult : purchasedLottoResults.purchasedLottoResults()) {
			stringBuilder.append(getPurchaseLottoResult(purchasedLottoResult.purchasedLottoResult()));
			stringBuilder.append(NEW_LINE);
		}
		System.out.println(stringBuilder);
	}

	public void printWinningLottoInputMessage() {
		System.out.println(WINNING_LOTTO_INPUT_MESSAGE);
	}

	public void printBonusNumberInputMessage() {
		System.out.println(NEW_LINE + BONUS_NUMBER_INPUT_MESSAGE);
	}

	public void printWinningResultMessage(WinningResultsDto winningResults) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(WINNING_STATISTICS_MESSAGE);
		stringBuilder.append(winningResults.winningResults().stream()
				.map(this::getWinningResult)
				.collect(Collectors.joining()));
		stringBuilder.append(getProfitRateMessage(winningResults.profitRate()));
		System.out.println(stringBuilder);
	}

	private String getLottoCountMessage(int count) {
		return count + LOTTO_COUNT_MESSAGE;
	}

	private String getPurchaseLottoResult(List<String> lottoResult) {
		return PURCHASE_LOTTO_RESULT_PREFIX + String.join(DELIMITER, lottoResult) + PURCHASE_LOTTO_RESULT_SUFFIX;
	}

	private String getWinningResult(WinningResultDto winningResult) {
		return getMatchingMessage(winningResult.matchCount(), winningResult.hasBonusNumber()) + " "
				+ "(" + String.format("%,d", winningResult.prize()) + "원" + ")" + " - " + winningResult.winningCount() + "개" + NEW_LINE;
	}

	private String getMatchingMessage(int count, boolean hasBonusNumber) {
		String matchingMessage = count + "개 일치";
		if (hasBonusNumber) {
			return matchingMessage + ", 보너스 볼 일치";
		}
		return matchingMessage;
	}

	private String getProfitRateMessage(double profitRate) {
		DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT);
		return "총 수익률은 " + decimalFormat.format(profitRate) + "%입니다.";
	}
}
