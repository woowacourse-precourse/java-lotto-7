package lotto;

import lotto.controller.Controller;
import lotto.model.LottoFactory;
import lotto.util.InputValidator;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        InputValidator inputValidator = new InputValidator();
        LottoFactory lottoFactory = new LottoFactory();

        Controller controller = new Controller(inputView, outputView, inputValidator, lottoFactory);
        controller.run();
    }
}
