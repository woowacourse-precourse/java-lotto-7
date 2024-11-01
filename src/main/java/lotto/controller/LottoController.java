package lotto.controller;

import java.util.List;
import lotto.view.ConsoleView;

public class LottoController {
    private final ConsoleView consoleView;

    public LottoController(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    public void run() {
        Integer purchaseAmount = consoleView.getPurchaseLottoAmount();

        // 로또 발급 ,,

        List<Integer> winningNumbers = consoleView.getWinningNumbers();
        Integer bonusNumbers = consoleView.getBonusNumber();

        // 로또 비교 ,,
    }
}
