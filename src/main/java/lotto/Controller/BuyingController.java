package lotto.Controller;

import lotto.Model.Lottos;
import lotto.View.InputView;
import lotto.View.OutputView;

public class BuyingController {

	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();
	private Lottos lottos = new Lottos();

	public BuyingController() {
		buyingLottos();
		showLottos();
	}

	private void buyingLottos() {
		int numberOfLotto = setNumberOfLotto();

		for (int i = 0; i < numberOfLotto; i++) {
			lottos.createLotto();
		}
	}

	private int setNumberOfLotto() {
		int number = lottos.calculateNumberOfLotto(inputView.readMoney());
		outputView.printBuyingNumber(number);

		return number;
	}

	private void showLottos() {
		System.out.println();
		outputView.printLottos(lottos.getLottos());
	}
}
