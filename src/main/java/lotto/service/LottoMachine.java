package lotto.service;

import lotto.domain.Amount;
import lotto.domain.BonusNumber;
import lotto.domain.LottoWinningStatistics;
import lotto.domain.WinningNumber;
import lotto.prompt.LottoDrawPrompt;
import lotto.prompt.LottoPurchasePrompt;

public class LottoMachine {

    private final LottoPurchase lottoPurchase = new LottoPurchase();
    private final LottoWinningStatistics statistics = new LottoWinningStatistics();
    private final LottoDraw lottoDraw = new LottoDraw(statistics);
    private Amount amount;


    public void purchase(LottoPurchasePrompt prompt) {
        amount = prompt.enterAmount();
        lottoPurchase.purchase(amount);
        prompt.printPurchased(lottoPurchase.retrievePurchasedLottoNumbers());
    }

    public void draw(LottoDrawPrompt prompt) {
        WinningNumber winningNumber = prompt.enterWinningNumber();
        BonusNumber bonusNumber = prompt.enterBonusNumber(winningNumber);
        lottoDraw.draw(lottoPurchase.getBundle(), winningNumber, bonusNumber);
        double returnRate = lottoDraw.calcReturnRate(lottoDraw.calcTotalPrize(), amount);
        prompt.printDrawResult(statistics);
        prompt.printReturnRate(returnRate);
    }
}
