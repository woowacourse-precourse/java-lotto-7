package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	
	private static List<Integer> numbers;
	
	public String readLine() {
		return Console.readLine();
	}

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

	public void winningNumber() {
		try {
			System.out.println();
			System.out.println("당첨 번호를 입력해 주세요.");
			String winning = readLine();
			WinningNumber winningNumber = new WinningNumber(winning);
			Lotto lotto = new Lotto(winningNumber.winningCheck());
			Input.setNumbers(lotto.listValueCheck());
		} catch (IllegalArgumentException e) {
			System.err.println(e);
			winningNumber();
		}
	}

	public void bonusInput() {
		try {
			System.out.println();
			System.out.println("보너스 번호를 입력해 주세요.");
			String bonus = readLine();
			BonusNumber bonusList = new BonusNumber(bonus, numbers);
			bonusList.bounsCheck();
		} catch(IllegalArgumentException e) {
			System.err.println(e);
			bonusInput();
		}
	}

	public static List<Integer> getNumbers() {
		return numbers;
	}

	public static void setNumbers(List<Integer> numbers) {
		Input.numbers = numbers;
	}

}
