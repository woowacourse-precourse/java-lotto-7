package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoFactory;
import lotto.service.LottoService;
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

        LottoController controller = new LottoController(
                inputView,
                outputView,
                inputValidator,
                lottoFactory
        );

        controller.run();
    }
}
