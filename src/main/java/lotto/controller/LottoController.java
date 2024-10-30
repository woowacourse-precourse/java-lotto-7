package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Cost;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;

import java.util.Arrays;

public class LottoController {
    private final InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        inputView.requestPurchaseAmount();
        Cost cost = initCost(inputView);

        inputView.requestWinningNumber();
        WinningNumbers winningNumbers = initWinningNumbers(inputView);

        inputView.requestBonusNumber();
        BonusNumber bonusNumber = initBonusNumbers(inputView);
    }

    private BonusNumber initBonusNumbers(InputView inputView) {
        try {
            return new BonusNumber(inputView.getInput());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return initBonusNumbers(inputView);
        }
    }

    private WinningNumbers initWinningNumbers(InputView inputView) {
        try {
            String input = inputView.getInput();
            return new WinningNumbers(Arrays.stream(input.split(","))
                    .toList());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return initWinningNumbers(inputView);
        }
    }

    private Cost initCost(InputView inputView) {
        try {
            return new Cost(inputView.getInput());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return initCost(inputView);
        }
    }
}
