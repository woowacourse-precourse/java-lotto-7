package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.view.View;

public class LottoController {
    public void run(){
        Lottos purchasedLottos =initLotts();
        printPurchaseResult(purchasedLottos);
        WinningNumbers winningNumbers=   inputWinningNumbers();



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

    private WinningNumbers inputWinningNumbers() {
        Lotto winnerLotto=  inputLotto();



    }


    private  Lotto inputLotto(){
        View.promptForWinningLotto();

    }





}
