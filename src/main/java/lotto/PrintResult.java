package lotto;

import java.util.List;

public class PrintResult {
    private final List<Integer> rankingCount;

    public PrintResult(LotteryProcess lotteryProcess) {
        this.rankingCount = lotteryProcess.getRankingCount();
    }

    public void printPrize() {
        System.out.println("당첨 통계\n---");
        for (LottoRank rank : LottoRank.values()) {
            int count = rankingCount.get(rank.ordinal());  // 등수에 맞는 인덱스로 당첨 횟수 조회
            System.out.printf("%s (%s원) - %d개\n",
                    rank.getDescription(),                     // 보너스 여부를 포함한 설명 출력
                    String.format("%,d", rank.getPrize()),
                    count);
        }
    }

    public double calculateEarnings() {
        double earnings = 0;
        for (LottoRank rank : LottoRank.values()) {
            int count = rankingCount.get(rank.ordinal());
            earnings += (rank.getPrize() * count);
        }

        return earnings;
    }
}
