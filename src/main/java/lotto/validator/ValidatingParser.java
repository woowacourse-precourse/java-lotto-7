package lotto.validator;

import java.util.ArrayList;
import java.util.List;

public class ValidatingParser {

	private static final int DIVIDE_NUMBER = 1000;

	private ValidatingParser() {
	}

	private static class Holder {
		private static final ValidatingParser INSTANCE = new ValidatingParser();
	}

	public static ValidatingParser getInstance() {
		return Holder.INSTANCE;
	}

	public int validatePurchaseAmount(String input) {
		validateNumber(input);
		validatePositiveNumber(input);
		validateDivideNumber(input);
		return 0;
	}

	public List<Integer> validateWinningNumbers(String input) {
		return new ArrayList<>();
	}

	public int validateBonusNumber(String input) {
		return 0;
	}

	private void validateNumber(String input) {

	}

	private void validatePositiveNumber(String input) {

	}

	private void validateDivideNumber(String input) {

	}
}
