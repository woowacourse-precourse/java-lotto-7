package lotto;

import static lotto.Initializer.controller;
import static lotto.Initializer.lottoMachine;
import static lotto.view.Prompt.BONUS_BALL;
import static lotto.view.Prompt.PURCHASE_AMOUNT;
import static lotto.view.Prompt.WINNING_NUMBERS;

import java.util.List;
import lotto.controller.Controller;
import lotto.view.input.InputHandler;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class Application {
    private final Controller controller;

    private Application(Controller controller) {
        this.controller = controller;
    }

    public static void main(String[] args) {
        Application app = init();
        app.run();
    }

    private static Application init() {
        return new Application(controller(lottoMachine()));
    }

    private void run() {
        int purchaseAmount = InputView.read(PURCHASE_AMOUNT, InputHandler::toInt);
        OutputView generatedLottoView = controller.purchaseLotto(purchaseAmount);
        generatedLottoView.print();

        List<Integer> numbers = InputView.read(WINNING_NUMBERS, InputHandler::toNumbers);
        int bonusBall = InputView.read(BONUS_BALL, InputHandler::toInt);
        OutputView lottoResultView = controller.matchWinningNumbers(numbers, bonusBall);
        lottoResultView.print();
    }
}
