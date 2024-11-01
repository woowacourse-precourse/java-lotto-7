package lotto.model;

import java.util.List;

import lotto.validator.LottoBonusValidator;

public class LottoBonus {
	private final int bonusNumber;

	public LottoBonus(int bonusNumber, List<Integer> lottoNumbers) {
		LottoBonusValidator.validateBonusNumber(bonusNumber, lottoNumbers);
		this.bonusNumber = bonusNumber;
	}
	
	public int getBonusNumbers() {
		return bonusNumber;
	}
}
