package lotto.view;

import java.util.List;

import lotto.model.Lotto;

public class OutputView {

	private static final String BUYING_NUMBER_MESSAGE = "%d개를 구매했습니다.";

	public void printBuyingNumber(int buyingNumber) {
		System.out.println();
		System.out.printf(BUYING_NUMBER_MESSAGE, buyingNumber);
	}

	public void printLottos(List<Lotto> lottos) {
		for (Lotto lotto : lottos) {
			System.out.println(lotto);
		}
		System.out.println();
	}
}
