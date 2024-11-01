package lotto.controller;

import lotto.model.Input;
import lotto.service.InputService;
import lotto.view.InputView;

import java.util.Set;

public class InputController {
    private final InputService inputService;

    public InputController(InputView inputView) {
        this.inputService = new InputService(inputView);
    }

    public Input getInput() {
        int buy = inputService.getValidBuyInput();
        Set<String> winningNum = inputService.getValidWinningNumInput();
        return new Input(buy, winningNum);
    }
}