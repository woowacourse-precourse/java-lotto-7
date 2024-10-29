package lotto.View;

import java.util.List;

import lotto.Model.Lotto;

public class OutputView {

	private static final String BUYING_NUMBER_MESSAGE = "%d개를 구매했습니다.";

	public void printBuyingNumber(int buyingNumber) {
		System.out.printf(BUYING_NUMBER_MESSAGE, buyingNumber);
		System.out.println();
	}

	public void printLottos(List<Lotto> lottos) {
		for (Lotto lotto : lottos) {
			System.out.println(lotto);
		}
	}
}
