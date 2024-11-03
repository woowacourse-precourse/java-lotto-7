package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoResultStatistics;

public class LottoOutputView {
    public int outputNumberOfLottoOutput(int lottoAmount) {
        int lottoTickets = lottoAmount / 1000;
        System.out.println();
        System.out.println(lottoTickets + "개를 구매했습니다.");
        return lottoTickets;
    }

    public void outputMakeRandomLottos(List<Lotto> purchasedLottos) {
        for (Lotto lotto : purchasedLottos) {
            System.out.println(lotto.lottoNumbers());
        }
    }

    public void outputResultStatistics(LottoResultStatistics statistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + statistics.getResultCount(LottoResult.THREE_NUMBER_MATCH) + "개");
        System.out.println("4개 일치 (50,000원) - " + statistics.getResultCount(LottoResult.FOUR_NUMBER_MATCH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statistics.getResultCount(LottoResult.FIVE_NUMBER_MATCH) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistics.getResultCount(LottoResult.FIVE_NUMBER_AND_BONUS_NUMBER_MATCH) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statistics.getResultCount(LottoResult.SIX_NUMBER_MATCH) + "개");
        System.out.println("총 수익률은 " + statistics.calculateProfitRate() + "%입니다.");
    }
}
