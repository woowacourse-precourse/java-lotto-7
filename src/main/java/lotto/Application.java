package lotto;

import lotto.controller.BuyingController;
import lotto.controller.WinningController;

public class Application {
	public static void main(String[] args) {
		BuyingController buyingController = new BuyingController();
		new WinningController(buyingController.getLottos());
	}
}
