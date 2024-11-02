package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        int amount = InputView.getAmount();
        OutputView.printLottoAmount(amount);
    }
}
