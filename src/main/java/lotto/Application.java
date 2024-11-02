package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoPublisher;
import lotto.model.ValidationManager;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ValidationManager validationManager = new ValidationManager();

        LottoController lottoController = new LottoController(inputView, outputView, validationManager);

        lottoController.play();
    }
}
