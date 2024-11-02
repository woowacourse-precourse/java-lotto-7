package lotto.view;

import java.util.List;

public class OutputView {

    public void outputPurchaseLottoNumber(int buyCount, List<List<Integer>> buyLottoList) {
        System.out.println(buyCount + "개를 구매했습니다.");
        for (List<Integer> lottoNumber : buyLottoList) {
            System.out.println(lottoNumber);
        }
    }
}
