package lotto;

import lotto.config.AppConfiguration;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lotto = new AppConfiguration().lottoController();
        lotto.run();
    }
}
