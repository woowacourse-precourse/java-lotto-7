package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	public void amountInput() {
		try {
			System.out.println("구입금액을 입력해 주세요.");
			String amount = readLine();
			Amount amountCheck = new Amount(amount);
		} catch (IllegalArgumentException e) {
			System.err.println("[ERROR] 숫자만 입력해주세요.");
			amountInput();
		}
	}
	
	public String readLine() {
		return Console.readLine();
	}
	
	
}
