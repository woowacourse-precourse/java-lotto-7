package lotto.service;

import static lotto.domain.Amount.LOTTO_PRICE;

import lotto.domain.Amount;
import lotto.domain.BonusNumber;
import lotto.domain.LottoBundle;
import lotto.domain.LottoWinningStatistics;
import lotto.domain.WinningNumber;
import lotto.prompt.LottoDrawPrompt;
import lotto.prompt.LottoPurchasePrompt;

public class LottoMachine {

    private final LottoWinningStatistics statistics = new LottoWinningStatistics();
    private final LottoDraw lottoDraw = new LottoDraw(statistics);
    private LottoBundle bundle;
    private Amount amount;


    public void purchase(LottoPurchasePrompt prompt) {
        amount = prompt.enterAmount();
        bundle = new LottoBundle(amount.getValue() / LOTTO_PRICE);
        prompt.printPurchased(bundle.retrieveLottoNumbers());
    }

    public void draw(LottoDrawPrompt prompt) {
        WinningNumber winningNumber = prompt.enterWinningNumber();
        BonusNumber bonusNumber = prompt.enterBonusNumber(winningNumber);
        lottoDraw.draw(bundle, winningNumber, bonusNumber);
        double returnRate = lottoDraw.calcReturnRate(lottoDraw.calcTotalPrize(), amount);
        prompt.printDrawResult(statistics);
        prompt.printReturnRate(returnRate);
    }
}
