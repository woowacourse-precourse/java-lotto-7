package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {

    private static final String OUTPUT_LOTTO_PURCHASE_AMOUNT = "개를 구매했습니다.";

    public static void outputLottoPurchaseAmount(int amount){
        System.out.println(amount + OUTPUT_LOTTO_PURCHASE_AMOUNT);
    }

    public static void outputPurchaseLotto(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }
}
