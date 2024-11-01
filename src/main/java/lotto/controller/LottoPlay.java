package lotto.controller;

import lotto.model.Lotto;

public class LottoPlay {
    private static final InputHandler input = new InputHandler();

    public static void lottoPlay_Input() {
        int purchaseAmount = input.getPurchaseAmount();
        GeneratorLotto.createLotto(purchaseAmount);
        Lotto winningNumbers = input.getWinningNumbers();
        System.out.println(winningNumbers.toString());
        input.getBonusNumber(winningNumbers);
    }

}
