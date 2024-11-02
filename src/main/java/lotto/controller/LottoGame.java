package lotto.controller;

import java.util.List;
import lotto.view.InputUtil;
import lotto.view.OutputUtil;

public class LottoGame {
    public void run(){
        int purchaseAmount = InputUtil.getLottoCount(InputUtil.getPurchaseAmount());
        OutputUtil.printPurchaseAmountMessage(purchaseAmount);
        OutputUtil.printUserLotto(OutputUtil.generateLottoNumbers(purchaseAmount));
        List<Integer> winningNumbers = InputUtil.getWinningNumbers();
        InputUtil.getBonusNumber(winningNumbers);
    }
}
