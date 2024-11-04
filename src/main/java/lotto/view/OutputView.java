package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {

    public void printPurchasedLottoCount(int lottoCount){
        System.out.println(lottoCount+"개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            lotto.printNumbers();
        }
    }
}
