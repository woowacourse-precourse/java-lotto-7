package lotto.validator;

import java.util.List;
import java.util.Set;

public interface Validator {
	void assertIsNumber(String input);
	
	void assertIsMultipleOfThousand(long purchaseAmount);
	
	void assertContainsSeparator(String input);
	
	void assertWinningNumbersCount(String[] inputSplits);
	
	void assertUniqueWinningNumbers(final int number, final Set<Integer> winningNumberSet);
	
	void assertRange(int number);
	
	void assertBonusNotInWinningNumbers(int bonusNumber, List<Integer> winningNumbers);
}
