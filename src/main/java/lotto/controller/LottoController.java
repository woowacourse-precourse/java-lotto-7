package lotto.controller;

import lotto.model.LottoManagementSystem;
import lotto.model.MyWallet;
import lotto.util.InputParser;
import lotto.view.LottoView;

import java.util.List;

public class LottoController {
    private final LottoView lottoView;

    private final MyWallet myWallet;
    private final LottoManagementSystem lottoManagementSystem;

    public LottoController(LottoView lottoView, LottoManagementSystem lottoManagementSystem) {
        this.lottoView = lottoView;
        this.lottoManagementSystem = lottoManagementSystem;
        this.myWallet = new MyWallet();
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
    }
}
