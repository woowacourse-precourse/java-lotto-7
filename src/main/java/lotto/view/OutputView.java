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
	private static final String WINNING_RESULT_PREFIX = " (";
	private static final String WINNING_RESULT_SUFFIX = ") ";
	private static final String WINNING_RESULT_DELIMITER = "- ";
	private static final String COUNT = "개\n";
	private static final String WON = "원";
	private static final String PRIZE_FORMAT = "%,d";
	private static final String DECIMAL_FORMAT = "#,###.#";
	private static final String MATCHING_MESSAGE = "개 일치";
	private static final String BONUS_BALL_MATCHING_MESSAGE = ", 보너스 볼 일치";
	private static final String PROFIT_RATE_MESSAGE = "총 수익률은 ";
	private static final String PERCENT_MESSAGE = "%입니다.";

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
		String winningResultMessage = WINNING_STATISTICS_MESSAGE + getWinningResults(winningResults.winningResults())
				+ getProfitRateMessage(winningResults.profitRate());
		System.out.println(winningResultMessage);
	}

	private String getLottoCountMessage(int count) {
		return count + LOTTO_COUNT_MESSAGE;
	}

	private String getPurchaseLottoResult(List<String> lottoResult) {
		return PURCHASE_LOTTO_RESULT_PREFIX + String.join(DELIMITER, lottoResult) + PURCHASE_LOTTO_RESULT_SUFFIX;
	}

	private String getWinningResults(List<WinningResultDto> winningResults) {
		return winningResults.stream()
				.map(this::getWinningResult)
				.collect(Collectors.joining());
	}

	private String getWinningResult(WinningResultDto winningResult) {
		return getMatchingMessage(winningResult.matchCount(), winningResult.hasBonusNumber()) + WINNING_RESULT_PREFIX
			+ String.format(PRIZE_FORMAT, winningResult.prize()) + WON + WINNING_RESULT_SUFFIX + WINNING_RESULT_DELIMITER + winningResult.winningCount() + COUNT;
	}

	private String getMatchingMessage(int count, boolean hasBonusNumber) {
		String matchingMessage = count + MATCHING_MESSAGE;
		if (hasBonusNumber) {
			return matchingMessage + BONUS_BALL_MATCHING_MESSAGE;
		}
		return matchingMessage;
	}

	private String getProfitRateMessage(double profitRate) {
		DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT);
		return PROFIT_RATE_MESSAGE + decimalFormat.format(profitRate) + PERCENT_MESSAGE;
	}
}
