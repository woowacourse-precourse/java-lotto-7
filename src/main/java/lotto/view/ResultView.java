package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.enums.LottoRank;

public class ResultView {
    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printLottoSetCount(int lottoSetCount) {
        System.out.println(lottoSetCount+"개를 구매했습니다.");
    }

    public static void printMatchResult(Map<LottoRank, Integer> matchResults) {
        LottoRank[] ranksToPrint = {LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST};
        DecimalFormat formatter = new DecimalFormat("#,###");
        for (LottoRank rank : ranksToPrint) {
            if (rank == LottoRank.SECOND) {
                System.out.println(rank.getMatchingCount() + "개 일치, 보너스 볼 일치 (" + formatter.format(rank.getPrize()) + "원) - " + matchResults.get(rank) + "개");
                continue;
            }
            System.out.println(rank.getMatchingCount() + "개 일치 (" + formatter.format(rank.getPrize()) + "원) - " + matchResults.get(rank) + "개");
        }
    }

    public static void printProfitRate(double profitRate){
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

}
