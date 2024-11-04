package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

import lotto.model.WinningResultDto;
import lotto.model.WinningResultsDto;

public class OutputView {

	private static final String DECIMAL_FORMAT = "#,###.#";

	public void printPurchasePriceInputMessage() {
		System.out.println("구입금액을 입력해 주세요.");
	}

	public void printErrorMessage(String errorMessage) {
		System.out.println(errorMessage);
	}

	public void printPurchaseLottoResultMessage(int count, List<List<String>> purchaseLottoResult) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n");
		stringBuilder.append(getLottoCountMessage(count));
		for (List<String> lotto : purchaseLottoResult) {
			stringBuilder.append(getPurchaseLottoResult(lotto));
			stringBuilder.append("\n");
		}
		System.out.println(stringBuilder);
	}

	public void printWinningLottoInputMessage() {
		System.out.println("당첨 번호를 입력해 주세요.");
	}

	public void printBonusNumberInputMessage() {
		System.out.println("\n" + "보너스 번호를 입력해 주세요.");
	}

	public void printWinningResultMessage(WinningResultsDto winningResults) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n");
		stringBuilder.append("당첨 통계");
		stringBuilder.append("\n");
		stringBuilder.append("---");
		stringBuilder.append("\n");
		stringBuilder.append(winningResults.winningResults().stream()
				.map(this::getWinningResult)
				.collect(Collectors.joining()));
		stringBuilder.append(getProfitRateMessage(winningResults.profitRate()));
		System.out.println(stringBuilder);
	}

	private String getLottoCountMessage(int count) {
		return count + "개를 구매했습니다.\n";
	}

	private String getPurchaseLottoResult(List<String> lottoResult) {
		return "[" + String.join(", ", lottoResult) + "]";
	}

	private String getWinningResult(WinningResultDto winningResult) {
		return getMatchingMessage(winningResult.matchCount(), winningResult.hasBonusNumber()) + " "
				+ "(" + String.format("%,d", winningResult.prize()) + "원" + ")" + " - " + winningResult.winningCount() + "개" + "\n";
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
