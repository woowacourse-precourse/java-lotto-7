package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        LottoController lottoController = new LottoController(applicationConfig);
        lottoController.execute();
    }
}
