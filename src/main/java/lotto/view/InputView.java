package lotto.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.util.Parse;

public class InputView {

	public static int purchaseMoney() {
		try {
			String money = Console.readLine();
			return Integer.parseInt(money);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
		}
	}

	public static List<Integer> winningNumber() {
		try {
			String winningNumber = Console.readLine();
			return Parse.parseToWinningNumber(winningNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
		}
	}

	public static int bonusNumber() {
		try {
			String bonusNumber = Console.readLine();
			return Integer.parseInt(bonusNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
		}
	}
}
