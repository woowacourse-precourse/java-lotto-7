package lotto.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.util.Parse;

public class InputView {
	public static int purchaseMoney() {
		while (true) {
			try {
				String money = Console.readLine();
				return Integer.parseInt(money);
			} catch (NumberFormatException e) {
				System.out.println("[ERROR] 구입 금액은 숫자여야 합니다.");
			}
		}
	}

	public static List<Integer> winningNumber() {
		while (true) {
			try {
				String winningNumber = Console.readLine();
				return Parse.parseToWinningNumber(winningNumber);
			} catch (NumberFormatException e) {
				System.out.println("[ERROR] 당첨 번호는 숫자여야 합니다.");
			} catch (IllegalArgumentException e) {
				OutputView.promptErrorMessage(e);
			}
		}
	}

	public static int bonusNumber() {
		while (true) {
			try {
				String bonusNumber = Console.readLine();
				return Integer.parseInt(bonusNumber);
			} catch (NumberFormatException e) {
				System.out.println("[ERROR] 보너스 번호는 숫자여야 합니다.");
			}
		}
	}
}
