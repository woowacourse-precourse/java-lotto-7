package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.util.LottoOperator;

import static lotto.constants.Purchase.LOTTO_PRICE_PER_UNIT;

public class OutputView {
    public void printUnitCount(int thousandUnitCount) {
        System.out.println(thousandUnitCount + "개를 구매했습니다.");
    }

    public void printPurchaseLottos(Lotto lotto) {
        System.out.println(lotto);
    }

    public void printLottoResult(Lottos lottos) {
        System.out.println("당첨 통계\n---");
        lottos.getMatchCount();
        for (LottoOperator value : LottoOperator.values()) {
            System.out.println(value.getResult());
        }
    }

    public void printRateOfReturn(int thousandUnitCount) {
        int result = 0;
        for (LottoOperator value : LottoOperator.values()) {
            result += value.getRateOfReturn();
        }
        int amount = thousandUnitCount * LOTTO_PRICE_PER_UNIT;
        System.out.println("총 수익률은 "+(result / amount) * 100+"%입니다.");
    }
}
