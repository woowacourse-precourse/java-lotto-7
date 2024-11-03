package lotto.model;

import java.util.List;

public class WinningLotto {

	private final Lotto winningNumbers;
	private final LottoNumber bonusNumber;

	public WinningLotto(Lotto winningNumbers, LottoNumber bonusNumber) {
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
	}

	private Lotto createWinningNumbers(List<Integer> winningNumbers, LottoCreator lottoCreator) {
		return lottoCreator.createWinningLotto(winningNumbers);
	}
}
