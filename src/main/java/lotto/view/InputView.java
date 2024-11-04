package lotto.view;

import static lotto.global.ErrorMessage.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private static final Pattern NUMBER_FORMAT = Pattern.compile("\\d+");
	private static final String LOTTO_NUMBER_SEPARATOR = ",";

	public static int readLottoPurchaseMoney() {
		OutputView.printMessage("구입금액을 입력해 주세요.");
		String amount = Console.readLine();
		validateNumber(amount);

		OutputView.printMessage("");
		return Integer.parseInt(amount);
	}

	public static List<Integer> readWinningNumbers() {
		OutputView.printMessage("당첨 번호를 입력해 주세요.");
		String[] winningNumbers = Console.readLine().split(LOTTO_NUMBER_SEPARATOR);
		validateNumbers(winningNumbers);

		return Arrays.stream(winningNumbers)
			.map(Integer::parseInt)
			.toList();
	}

	public static int readBonusNumber() {
		OutputView.printMessage("보너스 번호를 입력해 주세요.");
		String bonusNumber = Console.readLine();
		validateNumber(bonusNumber);

		return Integer.parseInt(bonusNumber);
	}

	private static void validateNumbers(String[] inputs) {
		for (String input : inputs) {
			validateNumber(input);
		}
	}

	private static void validateNumber(String input) {
		if (!NUMBER_FORMAT.matcher(input).matches()) {
			throw new IllegalArgumentException(INVALID_MONEY_TYPE_ERROR.getMessage());
		}
	}
}
