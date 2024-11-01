package lotto.controller;

import lotto.model.Price;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoCreateController {

	private final InputView inputView;
	private final OutputView outputView;

	public LottoCreateController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
	}

	private Price getPurchasePrice() {
		try {
		} catch (IllegalArgumentException exception) {
			outputView.printErrorMessage(exception.getMessage());
			return getPurchasePrice();
		}
	}
}
