package lotto;

import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        LottoController lottoController = new LottoController(outputView);
        lottoController.run();
    }
}
