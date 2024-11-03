package lotto.controller;

import lotto.model.LottoCreator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	private final InputView inputView;
	private final OutputView outputView;
	private final LottoCreator lottoCreator;

	public LottoController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		LottoCreateController lottoCreateController = new LottoCreateController(inputView, outputView);
		lottoCreateController.run();
	}
}
