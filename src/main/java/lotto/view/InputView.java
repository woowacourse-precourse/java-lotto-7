package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.exception.ErrorMessage.INPUT_BLANK;
import static lotto.exception.ErrorMessage.INPUT_NOT_DIGIT;

public class InputView {
	private static InputView instance;

	private InputView() {
	}

	public static InputView getInstance() {
		if (instance == null) {
			instance = new InputView();
		}

		return instance;
	}

	public String readInput() {
		return Console.readLine();
	}

	public void closeRead() {
		Console.close();
	}

	public String readPurchaseAmountInput() {
		String input = Console.readLine();
		validatePurchaseAmount(input);

		return Integer.parseInt(input);
	}

	public String readLottoNumbersInput() {
		String input = Console.readLine();
		validateLottoNumbers(input);

		return input;
	}

	public int readBonusNumberInput() {
		String input = Console.readLine();
		validateBonusNumberInput(input);

		return Integer.parseInt(input);
	}

	private void validatePurchaseAmount(String input) {
		validateNotBlank(input);
		validateDigit(input);
	}

	private void validateLottoNumbers(String input) {
		validateNotBlank(input);
	}

	private void validateBonusNumberInput(String input) {
		validateNotBlank(input);
		validateDigit(input);
	}


}
