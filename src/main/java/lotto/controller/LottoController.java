package lotto.controller;

import lotto.domain.Money;
import lotto.view.View;

public class LottoController {
    public void run(){
        initLotts();




    }

    private void initLotts(){
        View.promptForPurchaseAmount();
        Money money =  new Money(View.inputLottoPurchaseAmount());
        return Lottos.purchaseLottos(money.getLottoQuantity());

    }




}
