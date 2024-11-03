package lotto;

import lotto.controllers.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lotto = new LottoController();
        lotto.run();
    }
}
