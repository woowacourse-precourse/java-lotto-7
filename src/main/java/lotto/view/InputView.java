package lotto.view;

import static lotto.model.ErrorMessage.INVALID_BONUS_NUMBER_INPUT;
import static lotto.model.ErrorMessage.INVALID_PRICE_INPUT;
import static lotto.model.ErrorMessage.INVALID_WINNING_NUMBERS_INPUT;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public int getPurchasePriceInput() {
		try {
			String purchasePrice = Console.readLine();
			return Integer.parseInt(purchasePrice);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(INVALID_PRICE_INPUT.getMessage());
		}
	}

	public List<Integer> getWinningNumbersInput() {
		try {
			String winningNumbers = Console.readLine();
			return parseToNumbers(winningNumbers);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_INPUT.getMessage());
		}
	}

	public int getBonusNumberInput() {
		try {
			return Integer.parseInt(Console.readLine());
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException(INVALID_BONUS_NUMBER_INPUT.getMessage());
		}
	}

	private List<Integer> parseToNumbers(String input) {
		return Arrays.stream(input.split(","))
				.map(Integer::parseInt)
				.toList();
	}
}
