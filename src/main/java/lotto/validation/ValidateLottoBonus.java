package lotto.validation;

import java.util.List;

public class ValidateLottoBonus {

	public static void validateBonusNumber(int bonusNumber, List<Integer> lottoNumbers) {
		validateRange(bonusNumber);
		validateNotInLottoNumbers(bonusNumber, lottoNumbers);
	}

	private static void validateRange(int bonusNumber) {
		if (bonusNumber < 1 || bonusNumber > 45) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
		}
	}

	private static void validateNotInLottoNumbers(int bonusNumber, List<Integer> lottoNumbers) {
		if (lottoNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.");
		}
	}
}
