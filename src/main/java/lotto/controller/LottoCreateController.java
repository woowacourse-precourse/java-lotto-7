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
		Price price = getPurchasePrice();
	}

	private Price getPurchasePrice() {
		try {
			outputView.printPurchasePriceInputMessage();
			int purchasePriceInput = inputView.getPurchasePriceInput();
			return new Price(purchasePriceInput);
		} catch (IllegalArgumentException exception) {
			outputView.printErrorMessage(exception.getMessage());
			return getPurchasePrice();
		}
	}
}
