package lotto.view;

import java.util.List;
import lotto.enums.LottoRank;
import lotto.exception.GeneralException;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoStatistic;

public class OutputView {
    public static void printLottoPurchaseResult(List<Lotto> lottos) {
        int numberOfLottos = lottos.size();
        System.out.println(numberOfLottos + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printLottoStatistic(LottoStatistic lottoStatistic) {
        System.out.println("당첨 통계\n---");
        for (LottoRank lottoRank : LottoRank.getAllLottoRanks()) {
            if (lottoRank.equals(LottoRank.LOSS)) {
                continue;
            }
            System.out.println(lottoRank.toString() + lottoStatistic.getCountByLottoRank(lottoRank) + "개");
        }
        System.out.println("총 수익률은 " + lottoStatistic.getProfitRate() + "입니다.");
    }

    public static void printError(GeneralException exception) {
        System.out.println(exception.getErrorMessage());
    }

}
