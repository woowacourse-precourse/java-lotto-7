package lotto.winning.view;

import java.util.Map;
import lotto.common.constant.RankConstant;

public class OutputWinningResultView {
    public void printRanksOfLottoTickets(Map<RankConstant, Integer> ranks) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + ranks.get(RankConstant.FIFTHRANK) + "개");
        System.out.println("4개 일치 (50,000원) - " + ranks.get(RankConstant.FOURTHRANK) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + ranks.get(RankConstant.THIRDRANK) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + ranks.get(RankConstant.SECONDRANK) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + ranks.get(RankConstant.FIRSTRANK) + "개");
        System.out.println();
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
