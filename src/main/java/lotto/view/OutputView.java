package lotto.view;

import java.util.List;

public class OutputView {

	public void printPurchasePriceInputMessage() {
		System.out.println("구입금액을 입력해 주세요.");
	}

	public void printErrorMessage(String errorMessage) {
		System.out.println(errorMessage);
	}

	private String getPurchaseLottoResult(List<String> lottoResult) {
		return "[" + String.join(", ", lottoResult) + "]";
	}
}
