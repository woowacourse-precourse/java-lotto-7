package lotto.controller;


import java.math.BigInteger;
import lotto.model.LottoBuy;
import lotto.view.LottoView;


public class LottoController {
   public void run() {
       try {
           BigInteger amount = LottoView.inputPurchaseAmount();
           LottoBuy purchase = new LottoBuy(amount);
           LottoView.printPurchaseResult(purchase.getNumberOfLottos());
       } catch (IllegalArgumentException e) {
           System.out.println(e.getMessage());
           return;
       }
   }
}
