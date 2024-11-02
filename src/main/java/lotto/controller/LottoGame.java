package lotto.controller;

import java.util.List;
import lotto.service.LottoGenerator;
import lotto.view.InputUtil;
import lotto.view.OutputView;

public class LottoGame {
    public void run(){
        int purchaseAmount = InputUtil.getLottoCount(InputUtil.getPurchaseAmount());
        OutputView.printPurchaseAmountMessage(purchaseAmount);
        OutputView.printUserLotto(LottoGenerator.generateLottoNumbers(purchaseAmount));
        List<Integer> winningNumbers = InputUtil.getWinningNumbers();
        InputUtil.getBonusNumber(winningNumbers);
    }
}
