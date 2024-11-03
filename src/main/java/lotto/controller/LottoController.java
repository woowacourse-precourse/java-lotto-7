package lotto.controller;

import lotto.model.LottoBundle;
import lotto.model.LottoCreator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	private final InputView inputView;
	private final OutputView outputView;
	private final LottoCreator lottoCreator;

	public LottoController(InputView inputView, OutputView outputView, LottoCreator lottoCreator) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.lottoCreator = lottoCreator;
	}

	public void run() {
		LottoCreateController lottoCreateController = new LottoCreateController(inputView, outputView, lottoCreator);
		LottoBundle lottoBundle = lottoCreateController.run();
		LottoDrawController lottoDrawController = new LottoDrawController(inputView, outputView, lottoCreator);
		lottoDrawController.run(lottoBundle);
	}
}
