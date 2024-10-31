package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.util.Parse;

public class InputView {

	public static int getPurchaseMoney() {
		try {
			String money = Console.readLine();
			return Parse.parseToInt(money);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
		}
	}
}
