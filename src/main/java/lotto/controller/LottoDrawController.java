package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoDrawController {

	private final InputView inputView;
	private final OutputView outputView;

	public LottoDrawController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}
}
