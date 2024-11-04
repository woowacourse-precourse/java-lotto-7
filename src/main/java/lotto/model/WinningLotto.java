package lotto.model;

import java.util.List;
import java.util.Map;

public class WinningLotto {

	private static final int WINNING_COUNT_INCREMENT = 1;

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

	public Map<Winning, Integer> drawLottoBundle(LottoBundle lottoBundle) {
		Map<Winning, Integer> winningResult = Winning.initializeWinningResults();
		lottoBundle.getLottos().stream()
				.map(this::getWinningResult)
				.forEach(result -> winningResult.put(result, winningResult.get(result) + WINNING_COUNT_INCREMENT));
		return winningResult;
	}

	private Winning getWinningResult(Lotto lotto) {
		List<LottoNumber> lottoNumbers = lotto.getNumbers();
		long winningCount = getWinningCount(lottoNumbers);
		boolean hasBonusNumber = lottoNumbers.contains(bonusNumber);
		return Winning.getWinningResult(winningCount, hasBonusNumber);
	}

	private long getWinningCount(List<LottoNumber> lottoNumbers) {
		return lottoNumbers.stream()
				.filter(this::drawLottoNumber)
				.count();
	}

	private boolean drawLottoNumber(LottoNumber lottoNumber) {
		return winningNumbers.getNumbers().contains(lottoNumber);
	}
}
