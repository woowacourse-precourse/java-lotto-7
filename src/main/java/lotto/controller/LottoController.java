package lotto.controller;

import lotto.model.LottoManagementSystem;
import lotto.model.LottoResult;
import lotto.model.MyWallet;
import lotto.model.YieldCalculator;
import lotto.util.InputParser;
import lotto.view.LottoView;

import java.util.List;

public class LottoController {
    private final LottoView lottoView;

    private final MyWallet myWallet;
    private final LottoManagementSystem lottoManagementSystem;
    private final LottoResult lottoResult;


    public LottoController(LottoView lottoView, YieldCalculator yieldCalculator) {
        this.lottoView = lottoView;
        this.lottoResult = new LottoResult();
        this.myWallet = new MyWallet();
        this.lottoManagementSystem = new LottoManagementSystem();
    }

    public void purchase(){
        String input = lottoView.purchaseInput();
        int money = Integer.parseInt(input);

        myWallet.saveMoney(money);
        myWallet.buyLottos();
        lottoView.printPurchase(myWallet.getLottos());
    }

    public void setWinningNumbers(){
        String input = lottoView.winningInput();
        List<Integer> numbers = InputParser.winningNumParse(input);
        String bonusInput = lottoView.bonusInput();
        int bonus = Integer.parseInt(bonusInput);

        lottoManagementSystem.setWinningNumbers(numbers);
        lottoManagementSystem.setBonusNumber(bonus);
    }

    public void printStat(){
        lottoManagementSystem.recordRanks(lottoResult,myWallet);
        lottoView.printStat(lottoResult);
        float yield = YieldCalculator.calculateYield(myWallet);
        lottoView.printYield(yield);
    }
}
