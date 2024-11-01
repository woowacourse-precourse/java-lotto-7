package lotto.Controller;

import lotto.domain.PurchaseAmount;
import lotto.view.InputView;
import lotto.domain.RandomLotto;
import lotto.view.OutputView;

import java.util.List;

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
        LottoList(purchaseAmount.calculateLottoCount());
    }
    public static void LottoList(int ticketCount){
        for(int i=0;i<ticketCount;i++){
            OutputView.printLottoList(RandomLotto.randomLottoNumber());
        }
    }
}
