package lotto;

import lotto.controller.LottoPurchaseController;

public class Application {
	public static void main(String[] args) {
		LottoPurchaseController LottoPurchaseController = new LottoPurchaseController();
		LottoPurchaseController.run();
	}
}