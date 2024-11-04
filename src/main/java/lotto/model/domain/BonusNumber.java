package lotto.model.domain;

import java.util.List;

public class BonusNumber {
	private final int bonusNumber;

	public BonusNumber(List<Integer> winningNumber, int bonusNumber) {
		validate(winningNumber, bonusNumber);
		this.bonusNumber = bonusNumber;
	}

	private void validate(List<Integer> winningNumber, int bonusNumber) {
		overInRange(winningNumber);
		duplicateEach(winningNumber, bonusNumber);
	}

	private void overInRange(List<Integer> winningNumber) {
		if (!winningNumber.stream().allMatch(number -> number >= 1 && number <= 45)) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
		}
	}

	private void duplicateEach(List<Integer> winningNumber, int bonusNumber) {
		if (winningNumber.contains(bonusNumber)) {
			throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복되지 않아야 합니다.");
		}
	}

	public int getBonusNumber() {
		return bonusNumber;
	}
}
