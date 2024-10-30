package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	public String readLine() {
		return Console.readLine();
	}

	public int amountInput() {
		try {
			System.out.println("구입금액을 입력해 주세요.");
			String amount = readLine();
			Amount amountCheck = new Amount(amount);
			return amountCheck.getAmount();
		} catch (IllegalArgumentException e) {
			System.err.println(e);
			amountInput();
		}
		return 0;
	}

	public void winningNumber() {
		try {
			System.out.println();
			System.out.println("당첨 번호를 입력해 주세요.");
			String winning = readLine();
			WinningNumber numberCheck = new WinningNumber(winning);
			numberCheck.winningCheck();

		} catch (IllegalArgumentException e) {
			System.err.println(e);
			winningNumber();
		}
	}

}
