package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {

    private static final Map<Integer, Long> PRIZE_MONEY = new HashMap<>();
    private static final int[] RANK_MAPPER = {-1, -1, -1, 5, 4, 3, 1};

    static {
        PRIZE_MONEY.put(1, 2_000_000_000L);
        PRIZE_MONEY.put(2, 30_000_000L);
        PRIZE_MONEY.put(3, 1_500_000L);
        PRIZE_MONEY.put(4, 50_000L);
        PRIZE_MONEY.put(5, 5_000L);
    }

    private final int userLottoCnt;
    private int[] matchCnts;
    private final Bonus bonus;

    public Calculator(List<Lotto> userLottos, Lotto targetLotto, Bonus bonus) {
        this.userLottoCnt = userLottos.size();
        this.bonus = bonus;
        initMatchCntList(userLottos, targetLotto);
    }


    private void initMatchCntList(List<Lotto> userLottos, Lotto targetLotto) {
        this.matchCnts = new int[6];
        for (Lotto lotto : userLottos) {
            int rank = RANK_MAPPER[lotto.getCnt(targetLotto)];
            if (rank == -1) {
                continue;
            }
            if (rank == 3 && lotto.contains(bonus)) {
                rank--;
                System.out.println(rank);
            }
            matchCnts[rank]++;
        }
    }

    private double calcRateOfReturn() {
        double sum = 0;
        for (int i = 3; i < matchCnts.length; i++) {
            sum += (matchCnts[i] * PRIZE_MONEY.get(i));
        }
        return sum / (userLottoCnt * 1000) * 100;
    }

    public String getRateOfReturn() {
        return "총 수익률은 " + calcRateOfReturn() + "%입니다.";
    }

    public String getResult() {
        return "3개 일치 (5,000원) - " + matchCnts[5] + "개" +
                "\n4개 일치 (50,000원) - " + matchCnts[4] + "개" +
                "\n5개 일치 (1,500,000원) - " + matchCnts[3] + "개" +
                "\n5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchCnts[2] + "개" +
                "\n6개 일치 (2,000,000,000원) - " + matchCnts[1] + "개";
    }
}
