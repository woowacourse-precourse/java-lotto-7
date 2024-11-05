package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputVIew = new InputView();
        OutputView outputView = new OutputView();
        LottoController lottoController = new LottoController(inputVIew, outputView);
        lottoController.startLotto();
    }
}
