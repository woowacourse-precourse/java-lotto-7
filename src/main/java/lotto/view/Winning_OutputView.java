package lotto.view;

import java.util.Map;
import lotto.constant.RankConstant;

public class Winning_OutputView {
    public void printRanks(Map<RankConstant, Integer> ranks) {
        // 출력 문구 좀 더 가독성 높이기
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (" + RankConstant.FIFTHRANK + "원) - " + ranks.get(RankConstant.FIFTHRANK) + "개");
        System.out.println("4개 일치 (" + RankConstant.FOURTHRANK + "원) - " + ranks.get(RankConstant.FOURTHRANK) + "개");
        System.out.println("5개 일치 (" + RankConstant.THIRDRANK + "원) - " + ranks.get(RankConstant.THIRDRANK) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + RankConstant.SECONDRANK + "원) - " + ranks.get(RankConstant.SECONDRANK) + "개");
        System.out.println("6개 일치 (" + RankConstant.FIRSTRANK + "원) - " + ranks.get(RankConstant.FIRSTRANK) + "개");
        System.out.println();
    }

    public void printRateOfWinning(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }
}
