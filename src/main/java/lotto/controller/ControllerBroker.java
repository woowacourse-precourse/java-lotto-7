package lotto.controller;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.win.WinningNumbers;
import lotto.view.View;

public class ControllerBroker {

    private static ControllerBroker instance;
    private final Supplier<LottoGame> budgetController;
    private final Supplier<Lotto> lottoController;
    private final Function<Lotto, WinningNumbers> winningNumbersFunction;
    private final BiConsumer<LottoGame, WinningNumbers> resultController;

    private ControllerBroker() {
        budgetController = new BudgetController();
        lottoController = new LottoController();
        winningNumbersFunction = new WinningNumbersController();
        resultController = new LottoResultController();
    }

    public static ControllerBroker getInstance() {
        if (instance == null) {
            instance = new ControllerBroker();
        }
        return instance;
    }

    public void run() {
        try {
            LottoGame game = budgetController.get();
            Lotto lotto = lottoController.get();
            WinningNumbers winningNumbers = winningNumbersFunction.apply(lotto);
            resultController.accept(game, winningNumbers);
        } catch (IllegalArgumentException e) {
            View.of(e.getMessage(), true);
        }
    }
}
