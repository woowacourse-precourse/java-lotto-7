package lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LottoStatistics {

    public enum LottoPrizeRank {
        FIRST(2000000000L),
        SECOND(30000000L),
        THIRD(1500000L),
        FOURTH(50000L),
        FIFTH(5000L);

        private final long prize;
        LottoPrizeRank(long prize) {
            this.prize = prize;
        }
        public long getPrize() {
            return prize;
        }
    }

    private final List<Integer> winningNum;
    private final int bonusNum;
    private static Lotto[] lottos;

    private static int firstPrizeNum;
    private static int secondPrizeNum;
    private static int thirdPrizeNum;
    private static int fourthPrizeNum;
    private static int fifthPrizeNum;

    private static double profitRate;


    public LottoStatistics(Lotto[] lottos, List<Integer> winningNum, int bonusNum) {
        this.winningNum = winningNum;
        this.lottos = lottos;
        this.bonusNum = bonusNum;
        firstPrizeNum = 0;
        secondPrizeNum = 0;
        thirdPrizeNum = 0;
        fourthPrizeNum = 0;
        fifthPrizeNum = 0;
    }

    public void compareNum() {
        for(Lotto lotto : lottos) {
            List<Integer> lottoNum = new ArrayList<>();
            lottoNum.addAll(lotto.getNumbers());
            discerning(lottoNum);
        }
    }

    public void discerning(List<Integer> lottoNum) {
        List<Integer> overlapNum = new ArrayList<>();
        overlapNum.addAll(lottoNum);
        overlapNum.retainAll(winningNum);
        if(overlapNum.size() == 3) {
            fifthPrizeNum++;
            return;
        }
        if(overlapNum.size() == 4) {
            fourthPrizeNum++;
            return;
        }
        if(overlapNum.size() == 5) {
            if(lottoNum.contains(bonusNum)) {
                secondPrizeNum++;
                return;
            }
            thirdPrizeNum++;
            return;
        }
        if(overlapNum.size() == 6) {
            firstPrizeNum++;
            return;
        }
    }

    public void calculateProfit() {
        long profit = LottoPrizeRank.FIFTH.getPrize()*fifthPrizeNum + LottoPrizeRank.FOURTH.getPrize()*fourthPrizeNum + LottoPrizeRank.THIRD.getPrize()*thirdPrizeNum + LottoPrizeRank.SECOND.getPrize()*secondPrizeNum + LottoPrizeRank.FIRST.getPrize()*firstPrizeNum;
        profitRate = ((double)profit / (lottos.length*1000)) * 100;
        profitRate = Math.round(profitRate * 10) / 10.0;
    }

    public void run() {
        compareNum();
        calculateProfit();

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + fifthPrizeNum + "개");
        System.out.println("4개 일치 (50,000원) - " + fourthPrizeNum + "개");
        System.out.println("5개 일치 (1,500,000원) - " + thirdPrizeNum + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + secondPrizeNum + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + firstPrizeNum + "개");
        DecimalFormat df = new DecimalFormat("#,##0.0");
        System.out.println("총 수익률은 " + df.format(profitRate) + "%입니다.");
    }

}
