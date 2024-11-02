package lotto;

import lotto.application.LottoController;
import lotto.view.impl.InputViewImpl;
import lotto.view.impl.OutViewImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(new InputViewImpl(), new OutViewImpl());
        lottoController.run();
    }
}
