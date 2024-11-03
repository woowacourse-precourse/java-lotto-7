package lotto.io.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.io.input.validation.UserInputValidation;

public class InputHandler {

	private final UserInputValidation userInputValidation;

	public InputHandler(UserInputValidation userInputValidation) {
		this.userInputValidation = userInputValidation;
	}

	public int getPurchaseAmountFromUser() {
		String inputPurchaseAmount = Console.readLine();
		userInputValidation.validatePurchaseAmount(inputPurchaseAmount);
		return Integer.parseInt(inputPurchaseAmount);
	}

}
