package lotto.controller;

import lotto.domain.Amount;
import lotto.domain.LottoBundle;
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
}
