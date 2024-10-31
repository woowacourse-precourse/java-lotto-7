package controller;

import view.InputView;

import java.util.List;

public class LottoController {

    public LottoController() {}

    public void run() {

        Integer cost = InputView.inputCost();
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        Integer bonusNumber = InputView.inputBonusNumber();

    }
}
