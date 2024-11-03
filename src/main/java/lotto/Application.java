package lotto;

import lotto.config.AppConfig;
import lotto.controller.LottoController;
import lotto.view.InputValidator;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        LottoController lottoController = appConfig.createLottoController();
        InputView inputView = appConfig.createInputView();
        InputValidator inputValidator = appConfig.createInputValidator();

        lottoController.run(inputView, inputValidator);
    }
}
