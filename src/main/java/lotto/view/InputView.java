package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public int getPurchasePriceInput() {
		try {
			String purchasePrice = Console.readLine();
			return Integer.parseInt(purchasePrice);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException("[ERROR] 구입금액은 숫자이어야 합니다.");
		}
	}
}
