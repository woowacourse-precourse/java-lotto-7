package lotto.controller;

import lotto.model.Money;
import lotto.model.WinningNumber;
import lotto.service.InputService;
import lotto.view.InputView;

import java.util.Set;

public class InputController {
    private final InputService inputService;

    public InputController(InputView inputView) {
        this.inputService = new InputService(inputView);
    }

    public Money getMoney() {
        int buy = inputService.getValidBuyInput();
        return new Money(buy);
    }

    public WinningNumber getWinningNumber() {
        Set<Integer> winningNumbers = inputService.getValidWinningNumInput();
        int bonusNumber = inputService.getValidBonusNumberInput();
        return new WinningNumber(winningNumbers, bonusNumber);
    }
}