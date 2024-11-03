package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoCreator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoCreator lottoCreator = new LottoCreator();
        LottoController lottoController = new LottoController(inputView, outputView, lottoCreator);
        lottoController.run();
    }
}
