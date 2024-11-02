package lotto.view;

import static lotto.util.Constants.INPUT_PURCHASE_AMOUNT;
import static lotto.util.Constants.OUTPUT_LOTTO_COUNT;

public class OutputView {
    public void printInputPurchaseAmount(){
        System.out.println(INPUT_PURCHASE_AMOUNT);
    }

    public void printOutputLottoCount(int lottoCount){
        System.out.println();
        System.out.println(lottoCount + OUTPUT_LOTTO_COUNT);
    }
}
