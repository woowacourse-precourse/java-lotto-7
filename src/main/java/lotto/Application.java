package lotto;

import lotto.controller.LottoVending;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoVending lottoVending = new LottoVending(inputView, outputView);

        lottoVending.take();
    }
}
