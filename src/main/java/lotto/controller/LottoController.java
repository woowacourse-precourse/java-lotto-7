package lotto.controller;

import lotto.model.LottoAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        // Amount 설정
        int amount = inputAmount();
        OutputView.printAmount(amount);
    }

    private int inputAmount() {
        try {
            LottoAmount lottoAmount = new LottoAmount(InputView.inputAmount());
            return lottoAmount.getAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputAmount();
        }
    }
}