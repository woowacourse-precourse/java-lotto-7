package lotto.view;

import static lotto.global.ErrorMessage.*;

import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private static final Pattern NUMBER_FORMAT = Pattern.compile("\\d+");

	public static int readLottoPurchaseMoney() {
		OutputView.printMessage("구입금액을 입력해 주세요.");
		String amount = Console.readLine();
		validateNumber(amount);

		OutputView.printMessage("");
		return Integer.parseInt(amount);
	}

	public static void validateNumber(String input) {
		if (!NUMBER_FORMAT.matcher(input).matches()) {
			throw new IllegalArgumentException(INVALID_MONEY_TYPE_ERROR.getMessage());
		}
	}
}
