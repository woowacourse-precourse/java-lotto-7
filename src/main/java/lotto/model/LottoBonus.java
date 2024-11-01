package lotto.model;

import java.util.List;

import lotto.validation.ValidateLottoBonus;

public class LottoBonus {
	private final int bonusNumber;

	public LottoBonus(int bonusNumber, List<Integer> lottoNumbers) {
		ValidateLottoBonus.validateBonusNumber(bonusNumber, lottoNumbers);
		this.bonusNumber = bonusNumber;
	}
	
	public int getBonusNumbers() {
		return bonusNumber;
	}
}
