package lotto.Controller;

import lotto.domain.PurchaseAmount;
import lotto.view.InputView;

public class LottoController {
    public LottoController(){
    }
    private static PurchaseAmount purchaseAmount;

    public void run(){
        String amount_str =InputView.purchaseAmount();
        PlayerAmount(amount_str);
    }
    public void PlayerAmount(String amount_str){
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount_str);
        // OutputView.playerAmount(purchaseAmount.calculateLottoCount);
    }
}
