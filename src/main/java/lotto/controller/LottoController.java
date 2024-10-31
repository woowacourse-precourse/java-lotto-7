package lotto.controller;

import lotto.model.domain.PurchaseMoney;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

	public void start() {
		PurchaseMoney purchaseMoney = inputPurchaseMoney();
	}

	private PurchaseMoney inputPurchaseMoney() {
		OutputView.inputPurchaseMoney();
		int purchaseMoney = InputView.getPurchaseMoney();

		return new PurchaseMoney(purchaseMoney);
	}
}
