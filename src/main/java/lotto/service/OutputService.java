package lotto.service;

import lotto.domain.Lotto;

import lotto.enums.Prize;

import java.util.List;
import java.util.Map;

import static lotto.constants.OutputViewConstants.*;

public class OutputService {
    public void showPurchaseAmount(int purchaseAmount) {
        System.out.println(purchaseAmount + PURCHASE_AMOUNT_DESCRIPTION);
    }

    public void showGeneratedLottoNumbers(List<Lotto> generatedLotto) {
        for (Lotto lotto : generatedLotto) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void showWinnerStatistic(Map<Prize, Integer> winnerResult) {
        System.out.println(STATISTIC_DESCRIPTION_PREFIX);
        System.out.println(STATISTIC_DESCRIPTION_DIVISION_LINE);
        for (Prize prize : winnerResult.keySet()) {
            System.out.println(prize.getPrizeInfo() + winnerResult.get(prize) + COUNT_SUFFIX);
        }
    }
}
