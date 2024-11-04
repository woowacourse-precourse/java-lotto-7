package lotto.view;

import static lotto.global.ErrorMessage.*;
import static lotto.global.LottoConstant.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private static final Pattern NUMBER_FORMAT = Pattern.compile("\\d+");

	public static int readLottoPurchaseMoney() {
		OutputView.printMessage("구입금액을 입력해 주세요.");
		int readLottoPurchaseMoney = readAmount();

		OutputView.printNewLine();
		return readLottoPurchaseMoney;
	}

	private static int readAmount() {
		try {
			String amount = Console.readLine();
			validateNumber(amount);
			return Integer.parseInt(amount);
		} catch (IllegalArgumentException exception) {
			OutputView.printMessage(exception.getMessage());

			return readAmount();
		}
	}

	public static List<Integer> readWinningNumbers() {
		OutputView.printMessage("당첨 번호를 입력해 주세요.");
		String[] winningNumbers = Console.readLine().split(LOTTO_NUMBER_SEPARATOR);
		validateNumbers(winningNumbers);

		OutputView.printNewLine();

		return Arrays.stream(winningNumbers)
			.map(Integer::parseInt)
			.toList();
	}

	public static int readBonusNumber() {
		OutputView.printMessage("보너스 번호를 입력해 주세요.");
		String bonusNumber = Console.readLine();
		validateNumber(bonusNumber);

		OutputView.printNewLine();

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
