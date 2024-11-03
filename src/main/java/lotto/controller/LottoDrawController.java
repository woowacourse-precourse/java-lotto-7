package lotto.controller;

import lotto.model.LottoCreator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoDrawController {

	private final InputView inputView;
	private final OutputView outputView;
	private final LottoCreator lottoCreator;

	public LottoDrawController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}
}
