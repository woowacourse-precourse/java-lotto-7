package lotto;

import lotto.config.Config;
import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Config config = new Config();
        LottoController lottoController = new LottoController(config);
        lottoController.run();

    }
}
