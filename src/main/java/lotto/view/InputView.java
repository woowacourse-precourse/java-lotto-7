package lotto.view;

import java.util.Arrays;
import java.util.List;

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

	public List<Integer> getWinningLottoInput() {
		String winningLotto = Console.readLine();
		return parseToNumbers(winningLotto);
	}

	private List<Integer> parseToNumbers(String input) {
		return Arrays.stream(input.split(","))
				.map(Integer::parseInt)
				.toList();
	}
}
