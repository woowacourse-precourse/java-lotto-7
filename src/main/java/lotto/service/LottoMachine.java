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
        /*
         * Console Input
         * */
        amount = prompt.enterAmount();

        /*
         * Business Logic
         * */
        bundle = new LottoBundle(amount.getValue() / LOTTO_PRICE);

        /*
         * Console Output
         * */
        prompt.printPurchased(bundle.retrieveLottoNumbers());
    }

    public void draw(LottoDrawPrompt prompt) {
        /*
         * Console Input
         * */
        WinningNumber winningNumber = prompt.enterWinningNumber();
        BonusNumber bonusNumber = prompt.enterBonusNumber(winningNumber);

        /*
         * Business Logic
         * */
        lottoDraw.draw(bundle, winningNumber, bonusNumber);
        double returnRate = lottoDraw.calcReturnRate(lottoDraw.calcTotalPrize(), amount);

        /*
         * Console Output
         * */
        prompt.printDrawResult(statistics);
        prompt.printReturnRate(returnRate);
    }
}
