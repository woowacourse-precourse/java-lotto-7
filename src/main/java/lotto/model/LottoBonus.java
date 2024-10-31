package lotto.model;

import java.util.List;

public class LottoBonus {
	private final int bonusNumber;

	public LottoBonus(int bonusNumber, List<Integer> numbers) {
		validateRange(bonusNumber);
		validateDuplicate(bonusNumber, numbers);
		this.bonusNumber = bonusNumber;
	}

	private void validateRange(int bonusNumber) {
		if (bonusNumber < 1 || bonusNumber > 45) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
		}
	}

	private void validateDuplicate(int bonusNumber, List<Integer> numbers) {
		if (numbers.contains(bonusNumber)) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
		}
	}
}
