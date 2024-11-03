package lotto.validator;

import java.util.Arrays;
import java.util.List;

public class ValidatingParser {
	private static final int MAX_NUMBER_LENGTH = 10;
	private static final int MIN_POSITIVE_NUMBER = 1;
	private static final String DELIMITER = ",";

	private ValidatingParser() {
	}

	private static class Holder {
		private static final ValidatingParser INSTANCE = new ValidatingParser();
	}

	public static ValidatingParser getInstance() {
		return Holder.INSTANCE;
	}

	public int validatePurchaseAmount(String input) {
		validateNumberOverFlow(input);
		int validNumber = parsedValidateNumber(input);
		validatePositiveNumber(validNumber);
		return validNumber;
	}

	public List<Integer> validateWinningNumbers(String input) {
		validateDelimiter(input);
		return parsedValidateNumbers(input);
	}

	public int validateBonusNumber(String input) {
		int parsedBonusNumber = parsedValidateBonusNumber(input);
		validatePositiveBonusNumber(parsedBonusNumber);
		return parsedBonusNumber;
	}

	private void validateNumberOverFlow(String input) {
		if (input.length() > MAX_NUMBER_LENGTH) {
			throw new IllegalArgumentException(InputValidationMessage.INVALID_PURCHASE_AMOUNT_OVER_FLOW.getMessage());
		}
	}

	private int parsedValidateNumber(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(InputValidationMessage.INVALID_PURCHASE_AMOUNT_FORMAT.getMessage());
		}
	}

	private void validatePositiveNumber(int validNumber) {
		if (validNumber < MIN_POSITIVE_NUMBER) {
			throw new IllegalArgumentException(InputValidationMessage.INVALID_PURCHASE_AMOUNT_NEGATIVE.getMessage());
		}
	}

	private void validateDelimiter(String input) {
		if (!input.contains(DELIMITER)) {
			throw new IllegalArgumentException(InputValidationMessage.MISSING_WINNING_NUMBERS_DELIMITER.getMessage());
		}
	}

	private List<Integer> parsedValidateNumbers(String input) {
		return Arrays.stream(input.split(DELIMITER))
			.map(number -> {
				if (number.length() > MAX_NUMBER_LENGTH) {
					throw new IllegalArgumentException(
						InputValidationMessage.INVALID_WINNING_NUMBERS_OVER_FLOW.getMessage());
				}
				try {
					return Integer.parseInt(number);
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException(
						InputValidationMessage.INVALID_WINNING_NUMBERS_FORMAT.getMessage());
				}
			}).toList();
	}

	private int parsedValidateBonusNumber(String input) {
		if (input.length() > MAX_NUMBER_LENGTH) {
			throw new IllegalArgumentException(InputValidationMessage.INVALID_BONUS_NUMBER_OVER_FLOW.getMessage());
		}
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(InputValidationMessage.INVALID_BONUS_NUMBER_FORMAT.getMessage());
		}
	}

	private void validatePositiveBonusNumber(int parsedBonusNumber) {
		if (parsedBonusNumber < MIN_POSITIVE_NUMBER) {
			throw new IllegalArgumentException(InputValidationMessage.INVALID_BONUS_NUMBER_NEGATIVE.getMessage());
		}
	}
}
