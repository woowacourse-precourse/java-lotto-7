package lotto;

import lotto.application.LottoController;
import lotto.view.impl.InputViewImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(new InputViewImpl());
        lottoController.run();

    }
}
