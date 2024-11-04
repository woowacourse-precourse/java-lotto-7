package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.util.LottoOperator;

import java.util.Arrays;

import static lotto.constants.Purchase.LOTTO_PRICE_PER_UNIT;

public class OutputView {
    private final static int RATIO_MULTIPLIER = 100;

    public void printUnitCount(int thousandUnitCount) {
        System.out.println(thousandUnitCount + "개를 구매했습니다.");
    }

    public void printPurchaseLottos(Lotto lotto) {
        System.out.println(lotto);
    }

    public void printLottoResult(Lotto winningNumber, int bonusNumber, Lottos lottos) {
        System.out.println("당첨 통계\n---");
        lottos.getMatchCount(winningNumber, bonusNumber);
        for (LottoOperator value : LottoOperator.values()) {
            System.out.println(value.getResult());
        }
    }

    public void printRateOfReturn(int thousandUnitCount) {
        int purchaseAmount = thousandUnitCount * LOTTO_PRICE_PER_UNIT;
        double winningsAmount = Arrays.stream(LottoOperator.values())
                .mapToDouble(LottoOperator::getRateOfReturn)
                .sum();
        double rateOfReturn = (winningsAmount / purchaseAmount) * RATIO_MULTIPLIER;
        System.out.println("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");
    }
}
