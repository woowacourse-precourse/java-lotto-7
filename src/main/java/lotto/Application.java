package lotto;

import lotto.controller.LottoController;
import lotto.view.InputVIew;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputVIew inputVIew = new InputVIew();
        OutputView outputView = new OutputView();
        LottoController lottoController = new LottoController(inputVIew, outputView);
        lottoController.startLotto();
    }
}
