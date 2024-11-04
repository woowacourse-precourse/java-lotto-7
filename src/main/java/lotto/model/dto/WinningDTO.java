package lotto.model.dto;

import java.util.List;

import lotto.model.domain.BonusNumber;
import lotto.model.domain.WinningNumber;

public record WinningDTO(WinningNumber winningNumber, BonusNumber bonusNumber) {
	public List<Integer> getWinningNumber() {
		return winningNumber.winningNumber();
	}

	public int getBonusNumber() {
		return bonusNumber.getBonusNumber();
	}
}
