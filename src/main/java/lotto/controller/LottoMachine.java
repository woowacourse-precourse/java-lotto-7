package lotto.controller;

import lotto.domain.Amount;
import lotto.domain.BonusNumber;
import lotto.domain.LottoBundle;
import lotto.domain.WinningNumber;
import lotto.prompt.LottoDrawPrompt;
import lotto.prompt.LottoPurchasePrompt;

public class LottoMachine {

    public static final int LOTTO_PRICE = 1000;
    private Amount amount;
    private LottoBundle bundle;


    public void purchase(LottoPurchasePrompt prompt) {
        amount = prompt.enterAmount();
        bundle = new LottoBundle(amount.getValue() / LOTTO_PRICE);
        prompt.printPurchased(bundle.retrieveLottoNumbers());
    }

    public void draw(LottoDrawPrompt prompt) {
        WinningNumber winningNumber = prompt.enterWinningNumber();
        BonusNumber bonusNumber = prompt.enterBonusNumber(winningNumber);
    }
}
