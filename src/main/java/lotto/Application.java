package lotto;

import lotto.domain.LottoSimulator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        int amount = InputView.getAmount();
        OutputView.printLottoAmount(amount);

        LottoSimulator lottoSimulator = new LottoSimulator(amount);
    }
}
