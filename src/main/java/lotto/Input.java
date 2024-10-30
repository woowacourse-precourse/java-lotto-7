package lotto;

import java.util.List;

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

	public List<Integer> winningNumber() {
		try {
			System.out.println();
			System.out.println("당첨 번호를 입력해 주세요.");
			String winning = readLine();
			WinningNumber numberCheck = new WinningNumber(winning);
			return numberCheck.winningCheck();

		} catch (IllegalArgumentException e) {
			System.err.println(e);
			winningNumber();
		}
		return null;
	}

	public int bonusInput(List<Integer> winningList) {
		try {
			System.out.println();
			System.out.println("보너스 번호를 입력해 주세요.");
			String bonus = readLine();
			BonusNumber bonusList = new BonusNumber(bonus, winningList);
			return bonusList.bounsCheck();
		} catch(IllegalArgumentException e) {
			System.err.println(e);
			bonusInput(winningList);
		}
		return 0;
	}

}
