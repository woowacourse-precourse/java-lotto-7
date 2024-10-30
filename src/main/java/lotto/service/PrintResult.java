package lotto.service;

import java.util.List;
import lotto.domain.LotteryProcess;
import lotto.domain.LottoRank;

public class PrintResult {
    private final List<Integer> rankingCount;

    public PrintResult(LotteryProcess lotteryProcess) {
        this.rankingCount = lotteryProcess.getRankingCount();
    }

    public void printPrize() {
        System.out.println("당첨 통계\n---");
        printRankingResult();
    }

    public double calculateEarnings() {
        double earnings = 0;
        for (LottoRank rank : LottoRank.values()) {
            int count = rankingCount.get(rank.ordinal());
            earnings += (rank.getPrize() * count);
        }

        return earnings;
    }

    private void printRankingResult() {
        for (LottoRank rank : LottoRank.values()) {
            int count = rankingCount.get(rank.ordinal());  // 등수에 맞는 인덱스로 당첨 횟수 조회
            System.out.printf("%s (%s원) - %d개\n",
                    rank.getDescription(),                 // 보너스 여부를 포함한 설명 출력
                    String.format("%,d", rank.getPrize()),
                    count);
        }
    }
}