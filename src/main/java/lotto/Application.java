package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = initLottoController();
        lottoController.buyLotto();
    }

    private static LottoController initLottoController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        return new LottoController(inputView, outputView);
    }
}
