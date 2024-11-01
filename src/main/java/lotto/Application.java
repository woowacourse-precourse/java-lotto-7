package lotto;

import lotto.Controller.LottoController;
import lotto.View.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoController lottoController = new LottoController();

        lottoController.purchaseLotto();
    }
}
