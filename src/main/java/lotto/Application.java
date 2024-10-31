package lotto;

import lotto.controller.LottoController;
import lotto.model.lotto.Lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();
        lottoController.run();
    }
}
