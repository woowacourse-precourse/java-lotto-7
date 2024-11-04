package lotto.view;

import java.util.List;
import lotto.enums.LottoRank;
import lotto.enums.OutputMessage;
import lotto.exception.GeneralException;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoStatistic;

public class OutputView {
    public static void printLottoPurchaseResult(List<Lotto> lottos) {
        int numberOfLottos = lottos.size();
        System.out.println(numberOfLottos + OutputMessage.LOTTO_COUNT_SUFFIX.getMessage());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printLottoStatistic(LottoStatistic lottoStatistic) {
        System.out.println(OutputMessage.LOTTO_STATISTICS_RESULT.getMessage());
        for (LottoRank lottoRank : LottoRank.getAllLottoRanks()) {
            if (lottoRank.equals(LottoRank.LOSS)) {
                continue;
            }
            System.out.println(lottoRank.toString() + lottoStatistic.getCountByLottoRank(lottoRank) + "개");
        }
        System.out.println(
                String.format(OutputMessage.LOTTO_PROFIT_RATE.getMessage(), lottoStatistic.getProfitRate().toString()));
    }

    public static void printError(GeneralException exception) {
        System.out.println(exception.getErrorMessage());
    }

}
