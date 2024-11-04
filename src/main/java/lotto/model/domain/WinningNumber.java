package lotto.model.domain;

import static lotto.model.domain.NumberConstant.MIN_RANGE_NUMBER;
import static lotto.model.domain.NumberConstant.MAX_RANGE_NUMBER;
import static lotto.model.domain.NumberConstant.NUMBER_COUNT;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record WinningNumber(List<Integer> winningNumber) {
	public WinningNumber {
		validate(winningNumber);
	}

	private void validate(List<Integer> winningNumber) {
		checkSizeSix(winningNumber);
		overInRange(winningNumber);
		duplicateEach(winningNumber);
	}

	private void checkSizeSix(List<Integer> winningNumber) {
		if (winningNumber.size() != NUMBER_COUNT) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
		}
	}

	private void overInRange(List<Integer> winningNumber) {
		if (!winningNumber.stream().allMatch(number -> number >= MIN_RANGE_NUMBER && number <= MAX_RANGE_NUMBER)) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이여야 합니다.");
		}
	}

	private void duplicateEach(List<Integer> winningNumber) {
		Set<Integer> filteredNumbers = new HashSet<>(winningNumber);
		if (filteredNumbers.size() != winningNumber.size()) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
		}
	}

	public static void validateDelimiter(String winningNumber) {
		if (!winningNumber.contains(Delimiter.COMMA.getDelimiter())) {
			throw new IllegalArgumentException("[ERROR] 구분자는 콤마(,)이어야 합니다.");
		}
	}
}
