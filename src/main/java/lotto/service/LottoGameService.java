package lotto.service;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Prize;
import lotto.domain.WinningNumber;
import lotto.view.InputView;

public class LottoGameService {
	private final InputView inputView;

	public LottoGameService(InputView inputView) {
		this.inputView = inputView;
	}

	public WinningNumber setWinningNumber() {
		List<Integer> winningNumbers = inputView.getWinningNumbers();
		int bonusNumber = inputView.getBonusNumber(winningNumbers);
		return new WinningNumber(winningNumbers, bonusNumber);
	}

	public LottoResult playLottoGame(List<Lotto> lottos, WinningNumber winningNumber) {

		LottoResult lottoResult = new LottoResult();

		for (Lotto lotto : lottos) {
			Prize prize = getPrize(lotto, winningNumber.getWinningNumbers(), winningNumber.getBonusNumber());
			lottoResult.addPrize(prize);
		}

		return lottoResult;
	}

	private Prize getPrize(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
		long matchCount = lotto.getNumbers().stream()
			.filter(winningNumbers::contains)
			.count();
		boolean matchBonus = lotto.getNumbers().contains(bonusNumber);

		return Prize.findPrize((int)matchCount, matchBonus);
	}
}
