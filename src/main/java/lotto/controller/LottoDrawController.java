package lotto.controller;

import java.util.List;

import lotto.model.LottoCreator;
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

	private List<Integer> getWinningNumbers() {
		outputView.printWinningLottoInputMessage();
		return inputView.getWinningNumbersInput();
	}
}
