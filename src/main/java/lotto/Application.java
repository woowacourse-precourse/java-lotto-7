package lotto;

import lotto.controller.LottoController;
import lotto.view.InputReader;

public class Application {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        LottoController lottoController = new LottoController(inputReader);

        lottoController.startLotto();
    }
}
