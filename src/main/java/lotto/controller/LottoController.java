package lotto.controller;

import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.view.View;

public class LottoController {
    public void run(){
        Lottos purchasedLottos =initLotts();
        printPurchaseResult(purchasedLottos);
        WinningNumbers winningNumbers=   inputWinningNumbers();

        LottoResult lottoResult = new LottoResult();
        lottoResult.calculateResult(purchasedLottos, winningNumbers);


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
        BonusNumber bonusNumber = inpuBonus();

        return new WinningNumbers(winnerLotto,bonusNumber);
    }


    private  Lotto inputLotto(){
        View.promptForWinningLotto();
        List<Integer> mainWinningNumbers  = View.inputWinningLotto();
        return new Lotto(mainWinningNumbers);
    }

    private  BonusNumber inpuBonus(){
        View.promptForWinningBonusNumber();
        int winningBonusNumberInput=   View.inputWinningBonusNumber();
        return new BonusNumber(winningBonusNumberInput);
    }



}
