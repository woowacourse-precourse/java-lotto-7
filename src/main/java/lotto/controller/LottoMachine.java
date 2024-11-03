package lotto.controller;

import lotto.domain.Amount;
import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;
import lotto.prompt.LottoDrawPrompt;
import lotto.prompt.LottoPurchasePrompt;
import lotto.service.LottoDraw;
import lotto.service.LottoPurchase;

public class LottoMachine {

    public static final int LOTTO_PRICE = 1000;
    private final LottoPurchase lottoPurchase = new LottoPurchase();
    private final LottoDraw lottoDraw = new LottoDraw();
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
        double totalPrize = lottoDraw.calcTotalPrize();
        double returnRate = lottoDraw.calcReturnRate(totalPrize, amount);
    }
}
