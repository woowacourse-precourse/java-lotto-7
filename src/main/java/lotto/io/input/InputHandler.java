package lotto.io.input;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.io.input.validation.UserInputValidation;

public class InputHandler {

	private static final String WINNING_NUMBERS_DELIMITER = ",";

	private final UserInputValidation userInputValidation;

	public InputHandler(UserInputValidation userInputValidation) {
		this.userInputValidation = userInputValidation;
	}

	public int getPurchaseAmountFromUser() {
		String inputPurchaseAmount = Console.readLine();
		userInputValidation.validatePurchaseAmount(inputPurchaseAmount);
		return Integer.parseInt(inputPurchaseAmount);
	}

	public List<Integer> getWinningNumbers() {
		String inputWinningNumbers = Console.readLine();
		userInputValidation.validateWinningNumbersDelimiter(inputWinningNumbers, WINNING_NUMBERS_DELIMITER);

		String[] splitWinningNumbers = inputWinningNumbers.split(WINNING_NUMBERS_DELIMITER);
		userInputValidation.validateWinningNumbers(splitWinningNumbers);

		return Arrays.stream(splitWinningNumbers)
			.map(String::trim)
			.map(Integer::parseInt)
			.toList();
	}

	public int getBonusNumber() {
		String inputBonusNumber = Console.readLine();
		userInputValidation.validateBonusNumberRange(inputBonusNumber);

		return Integer.parseInt(inputBonusNumber);
	}

}
