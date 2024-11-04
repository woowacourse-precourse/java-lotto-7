package lotto.controller;

import java.util.List;
import java.util.Map;

import lotto.model.LottoBundle;
import lotto.model.LottoCreator;
import lotto.model.Winning;
import lotto.model.WinningLotto;
import lotto.model.WinningResultsDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoDrawController {

	private final InputView inputView;
	private final OutputView outputView;
	private final LottoCreator lottoCreator;

	public LottoDrawController(InputView inputView, OutputView outputView, LottoCreator lottoCreator) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.lottoCreator = lottoCreator;
	}

	public void run(LottoBundle lottoBundle) {
		WinningLotto winningLotto = getWinningLotto();
	}

	private WinningLotto getWinningLotto() {
		try {
			List<Integer> winningNumbers = getWinningNumbers();
			int bonusNumber = getBonusNumber();
			return new WinningLotto(winningNumbers, bonusNumber, lottoCreator);
		} catch (IllegalArgumentException exception) {
			outputView.printErrorMessage(exception.getMessage());
			return getWinningLotto();
		}
	}

	private List<Integer> getWinningNumbers() {
		outputView.printWinningLottoInputMessage();
		return inputView.getWinningNumbersInput();
	}

	private int getBonusNumber() {
		outputView.printBonusNumberInputMessage();
		return inputView.getBonusNumberInput();
	}

	private void drawLottoBundle(WinningLotto winningLotto, LottoBundle lottoBundle) {
		Map<Winning, Integer> winningResult = winningLotto.drawLottoBundle(lottoBundle);
		double profitRate = lottoBundle.getProfitRate(winningResult);
		WinningResultsDto winningResultsDto = WinningResultsDto.from(winningResult, profitRate);
		outputView.printWinningResultMessage(winningResultsDto);
	}
}
