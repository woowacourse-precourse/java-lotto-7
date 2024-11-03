package lotto;

import lotto.controller.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(new InputView(), new OutputView());

        lottoMachine.lottery();
    }
}
