package lotto.controller;

import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class BuyingController {

	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();
	private Lottos lottos = new Lottos();

	public BuyingController() {
		buyingLottos();
		showLottos();
	}

	public Lottos getLottos() {
		return lottos;
	}

	private void buyingLottos() {
		int numberOfLotto = setNumberOfLotto();

		for (int i = 0; i < numberOfLotto; i++) {
			lottos.createLotto();
		}
	}

	private int setNumberOfLotto() {
		int number = 0;

		while (true) {
			try {
				number = lottos.calculateNumberOfLotto(inputView.readMoney());
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		outputView.printBuyingNumber(number);

		return number;
	}

	private void showLottos() {
		System.out.println();
		outputView.printLottos(lottos.getLottos());
	}
}
