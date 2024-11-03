package lotto;

import static lotto.Initializer.controller;
import static lotto.Initializer.lottoMachine;
import static lotto.view.input.Prompt.BONUS_BALL;
import static lotto.view.input.Prompt.PURCHASE_AMOUNT;
import static lotto.view.input.Prompt.WINNING_NUMBERS;

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
        repeatOnException(this::purchaseLotto);
        repeatOnException(this::matchWinningNumbers);
    }

    private void repeatOnException(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    private void purchaseLotto() {
        int purchaseAmount = InputView.read(PURCHASE_AMOUNT, InputHandler::toInt);
        OutputView view = controller.purchaseLotto(purchaseAmount);

        view.print();
    }

    private void matchWinningNumbers() {
        List<Integer> numbers = InputView.read(WINNING_NUMBERS, InputHandler::toNumbers);
        int bonusBall = InputView.read(BONUS_BALL, InputHandler::toInt);
        OutputView view = controller.matchWinningNumbers(numbers, bonusBall);

        view.print();
    }
}
