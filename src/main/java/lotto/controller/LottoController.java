package lotto.controller;

import java.util.List;
import lotto.view.InputView;

public class LottoController {
    public void run() {
        InputView.inputPurchasePrice();
        List<Integer> winningNumber = InputView.inputWinningNumber();
        InputView.inputBonusNumber(winningNumber);
    }
}
