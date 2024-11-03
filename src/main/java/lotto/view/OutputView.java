package lotto.view;

import java.util.List;

public class OutputView {

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
		stringBuilder.append("\n");
		System.out.println(stringBuilder);
	}

	public void printWinningLottoInputMessage() {
		System.out.println("당첨 번호를 입력해 주세요.");
	}

	private String getLottoCountMessage(int count) {
		return count + "개를 구매했습니다.\n";
	}

	private String getPurchaseLottoResult(List<String> lottoResult) {
		return "[" + String.join(", ", lottoResult) + "]";
	}
}
