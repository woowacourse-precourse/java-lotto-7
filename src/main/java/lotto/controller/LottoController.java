package lotto.controller;

import static lotto.view.InputView.getPurchase;
import static lotto.view.InputView.getWinningNumbers;

import java.util.List;

public class LottoController {
    public void start() {
        int purchase = getPurchase();

        List<Integer> winningNumbers = getWinningNumbers();
    }
}
