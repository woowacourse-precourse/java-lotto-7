package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	public void amountInput() {
		try {
			System.out.println("구입금액을 입력해 주세요.");
			String amount = readLine();
			Amount amountCheck = new Amount(amount);
		} catch (IllegalArgumentException e) {
			System.err.println(e);
			amountInput();
		}
	}

	public String readLine() {
		return Console.readLine();
	}

}
