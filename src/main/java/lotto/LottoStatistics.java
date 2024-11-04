package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStatistics {

    private final List<Integer> winningNum;
    private final int bonusNum;
    private static Lotto[] lottos;

    private static int first;
    private static int second;
    private static int third;
    private static int fourth;
    private static int fifth;

    private static double profitRate;


    public LottoStatistics(Lotto[] lottos, List<Integer> winningNum, int bonusNum) {
        this.winningNum = winningNum;
        this.lottos = lottos;
        this.bonusNum = bonusNum;
        first = 0;
        second = 0;
        third = 0;
        fourth = 0;
        fifth = 0;
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
            fifth++;
            return;
        }
        if(overlapNum.size() == 4) {
            fourth++;
            return;
        }
        if(overlapNum.size() == 5) {
            if(lottoNum.contains(bonusNum)) {
                second++;
                return;
            }
            third++;
            return;
        }
        if(overlapNum.size() == 6) {
            first++;
            return;
        }
    }

    public void calculateProfit() {
        long profit = 5000L*fifth + 50000L*fourth + 1500000L*third + 30000000L*second + 2000000000L*first;
        profitRate = (double)profit / (lottos.length*1000);
        profitRate = Math.round(profitRate * 100);
    }

    public void run() {
        compareNum();
        calculateProfit();

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + fifth + "개");
        System.out.println("4개 일치 (50,000원) - " + fourth + "개");
        System.out.println("5개 일치 (1,500,000원) - " + third + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + second + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + first + "개");
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

}
