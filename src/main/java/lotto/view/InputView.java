package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public String readPurchaseAmount() {
		return Console.readLine();
	}

	private void validateNotBlank(String input) {
		if (input.isBlank()) {
			System.out.println("[ERROR] 입력값은 비어있지 않아야 합니다.");
		}
	}
}
