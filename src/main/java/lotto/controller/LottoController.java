package lotto.controller;

import java.util.List;
import lotto.view.UserInput;

public class LottoController {
    private final UserInput userInput;

    public LottoController() {
        this.userInput = new UserInput();
    }

    public void process() {
        int amount = userInput.getPurchaseAmount();

        List<Integer> winNumbers = userInput.inputWinNumbers();

        int bonusNumber = userInput.inputBonusNumber(winNumbers);
    }
}
