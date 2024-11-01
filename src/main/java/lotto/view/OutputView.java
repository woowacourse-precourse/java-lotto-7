package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.util.LottoOperator;

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
}
