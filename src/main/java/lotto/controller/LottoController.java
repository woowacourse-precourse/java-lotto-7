package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.View;

public class LottoController {
    public void run(){
        Lottos purchasedLottos =initLotts();
        printPurchaseResult(purchasedLottos);




    }

    private Lottos initLotts(){
        View.promptForPurchaseAmount();
        Money money =  new Money(View.inputLottoPurchaseAmount());


        return new Lottos(money.getLottoQuantity());

    }

    private void printPurchaseResult(Lottos purchasedLottos) {
        System.out.println();
        View.printPurchaseResult(purchasedLottos);
    }


}
