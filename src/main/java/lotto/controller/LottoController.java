package lotto.controller;

import lotto.domain.LottoUniqueGenerator;
import lotto.domain.MyLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }
    public void run() {
        int numberOfLotto = inputView.inputPurchaseAmountGuide();
        MyLotto myLotto = MyLotto.createLottos(numberOfLotto, LottoUniqueGenerator.getLottoUniqueGenerator());


    }
}
