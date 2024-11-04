package lotto;

import lotto.controller.LottoController;
import lotto.controller.generator.NumberGenerator;
import lotto.controller.generator.RandomUniqueNumberGenerator;
import lotto.model.Lotto;
import lotto.view.input.ConsoleInputView;
import lotto.view.input.InputView;
import lotto.view.output.ConsoleOutputView;
import lotto.view.output.OutputView;

public class Application {

    public static void main(String[] args) {
        final InputView inputView = new ConsoleInputView();
        final OutputView outputView = new ConsoleOutputView();
        final NumberGenerator numberGenerator =
                new RandomUniqueNumberGenerator(Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER);

        final LottoController lottoController = new LottoController(inputView, outputView, numberGenerator);
        lottoController.start();
    }
}
