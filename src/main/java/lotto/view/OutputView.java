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
		stringBuilder.append(count);
		stringBuilder.append("개를 구매했습니다.");
		stringBuilder.append("\n");
		System.out.println(stringBuilder);
	}

	private String getPurchaseLottoResult(List<String> lottoResult) {
		return "[" + String.join(", ", lottoResult) + "]";
	}
}
