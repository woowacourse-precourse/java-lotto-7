package lotto.model;

public class WinningLotto {

	private final Lotto winningNumbers;
	private final LottoNumber bonusNumber;

	public WinningLotto(Lotto winningNumbers, LottoNumber bonusNumber) {
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
	}
}
