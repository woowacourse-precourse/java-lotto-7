package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private final OutputView outputView;

	public InputView(OutputView outputView) {
		this.outputView = outputView;
	}

	public String readLine() {
		return Console.readLine();
	}

	public String getPurchaseAmount() {
		outputView.printPurchaseAmountMessage();
		return readLine();
	}
}
