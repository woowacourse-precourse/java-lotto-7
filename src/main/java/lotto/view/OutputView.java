package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.view.constant.OutputConstant;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printPurchasedLottoMessage(int purchaseCount) {
        System.out.println(purchaseCount + OutputConstant.PURCHASED_LOTTO_MESSAGE);
    }

    public void printPurchasedLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printLottoResult(LottoResult result) {
        System.out.println(OutputConstant.RESULT_STATS_MESSAGE + "\n" + OutputConstant.SLASHES);
        Map<LottoRank, Integer> stats = result.getResultStats();
        List<LottoRank> rankValuesReversed = LottoRank.getRankValuesReversed();
        for (LottoRank rank : rankValuesReversed) {
            System.out.println(rank.getResultMessage() + OutputConstant.SLASH + stats.get(rank) + OutputConstant.UNIT);
        }
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf(OutputConstant.TOTAL_RATE_OF_RETURN, rateOfReturn);
    }
}
