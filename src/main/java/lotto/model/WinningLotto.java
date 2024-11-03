package lotto.model;

import java.util.List;

public class WinningLotto {

	private final Lotto winningNumbers;
	private final LottoNumber bonusNumber;

	public WinningLotto(List<Integer> winningNumbers, int bonusNumber, LottoCreator lottoCreator) {
		this.winningNumbers = createWinningNumbers(winningNumbers, lottoCreator);
		this.bonusNumber = createBonusNumber(bonusNumber);
	}

	private Lotto createWinningNumbers(List<Integer> winningNumbers, LottoCreator lottoCreator) {
		return lottoCreator.createWinningLotto(winningNumbers);
	}

	private LottoNumber createBonusNumber(int number) {
		return LottoNumber.from(number);
	}
}
