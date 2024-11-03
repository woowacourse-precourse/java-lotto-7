package lotto;

import lotto.config.AppConfig;
import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputViewImpl;
import lotto.view.OutputViewImpl;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoController lottoController = appConfig.getLottoController();
        lottoController.run();
    }
}
