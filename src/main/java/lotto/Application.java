package lotto;

import lotto.controller.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoMachine lottoMachine = new LottoMachine(new InputView(), new OutputView());
        lottoMachine.run();
    }
}
