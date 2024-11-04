package lotto;

import lotto.controller.LottoGameController;
import lotto.util.RetryTemplate;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RetryTemplate retryTemplate = new RetryTemplate(outputView);

        LottoGameController gameController = new LottoGameController(
                inputView,
                outputView,
                retryTemplate
        );
        gameController.play();
    }
}