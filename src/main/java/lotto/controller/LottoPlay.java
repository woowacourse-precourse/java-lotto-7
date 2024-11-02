package lotto.controller;

import java.util.List;
import lotto.model.Lotto;

public class LottoPlay {
    private static final InputHandler input = new InputHandler();

    public static void lottoPlay_Input() {
        int purchaseAmount = input.getPurchaseAmount();
        List<Lotto> lottoList = GeneratorLotto.createLotto(purchaseAmount);
        Lotto winningNumbers = input.getWinningNumbers();
        System.out.println(winningNumbers.toString());
        int bonusNumber = input.getBonusNumber(winningNumbers);
        MatchingLotto.matchingLotto(lottoList, winningNumbers, bonusNumber);
    }

}
