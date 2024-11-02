package lotto;

import lotto.controller.LottoMachine;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(new InputView());
        lottoMachine.lottery();
    }
}
