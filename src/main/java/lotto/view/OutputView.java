package lotto.view;

import lotto.model.Lotto;

import java.util.List;

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

    public void printOutputLottoNumbers(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            System.out.println(lotto);
        }
    }
}
