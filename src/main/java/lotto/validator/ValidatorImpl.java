package lotto.validator;

import java.util.List;
import java.util.Set;

import static lotto.constant.Digit.*;
import static lotto.constant.ErrorMessage.*;
import static lotto.constant.Regex.*;

public class ValidatorImpl implements Validator {
	private static final Validator INSTANCE;
	
	static {
		INSTANCE = new ValidatorImpl();
	}

	private ValidatorImpl() {}
	
	public static Validator getInstance() {
		return INSTANCE;
	}
	
	@Override
	public void assertIsNumber(final String input) {
		if (!input.matches(REGEX_NUMBER)) {
			throw new IllegalArgumentException(IS_NOT_NUMBER);
		}
	}
	
	@Override
	public void assertIsMultipleOfThousand(final long purchaseAmount) {
		if (purchaseAmount % LOTTO_PRICE != REMAINDER_ZERO) {
			throw new IllegalArgumentException(IS_NOT_MULTIPLE_OF_THOUSAND);
		}
	}
	
	@Override
	public void assertContainsSeparator(final String input) {
		if (!input.matches(REGEX_CONTAINS_SEPARATOR)) {
			throw new IllegalArgumentException(CANNOT_SPLIT_BY_SEPARATOR);
		}
	}
	
	@Override
	public void assertWinningNumbersCount(final String[] inputSplits) {
		if (inputSplits.length != NUMBER_COUNT) {
			throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_COUNT);
		}
	}
	
	@Override
	public void assertUniqueWinningNumbers(final int number, final Set<Integer> winningNumberSet) {
		if (!winningNumberSet.add(number)) {
			throw new IllegalArgumentException(DUPLICATED_NUMBERS);
		}
	}
	
	@Override
	public void assertRange(final int number) {
		if (number < START_NUMBER || number > END_NUMBER) {
			throw new IllegalArgumentException(INVALID_RANGE);
		}
	}
	
	@Override
	public void assertBonusNotInWinningNumbers(final int bonusNumber, final List<Integer> winningNumbers) {
		if (winningNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException(WINNING_NUMBERS_CONTAIN_BONUS_NUMBER);
		}
	}
}
