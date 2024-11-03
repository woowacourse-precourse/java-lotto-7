package lotto.controller;

import lotto.model.LottoVendingMachine;
import lotto.model.MyWallet;
import lotto.view.LottoView;

public class LottoController {
    private final LottoView lottoView;

    private final MyWallet myWallet;

    public LottoController(LottoView lottoView) {
        this.lottoView = lottoView;
        this.myWallet = new MyWallet();
    }

    public void purchase(){
        String input = lottoView.purchaseInput();
        int money = Integer.parseInt(input);

        myWallet.saveMoney(money);
        myWallet.buyLottos();
        lottoView.printPurchase(myWallet.getLottos());
    }
}
