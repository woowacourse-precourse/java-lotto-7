package lotto;

import static lotto.RANK.FIFTH;
import static lotto.RANK.FIRST;
import static lotto.RANK.FOURTH;
import static lotto.RANK.SECOND;
import static lotto.RANK.THIRD;

import java.util.HashMap;
import java.util.Map;

public class LottoService {
    static int FIRST_PRIZE = 2000000000;
    static int SECOND_PRIZE = 30000000;
    static int THIRD_PRIZE = 1500000;
    static int FOURTH_PRIZE = 50000;
    static int FIFTH_PRIZE = 5000;


    private final Map<RANK, Integer> result;
    private float initCost = 0;

    LottoService(HashMap<RANK, Integer> result, float initCost) {
        this.result = result;
        this.initCost = initCost;
    }

    public int get(RANK rank) {
        return result.getOrDefault(rank, 0);
    }

    private double getRate() {
        double sum = result.getOrDefault(RANK.FIRST, 0) * FIRST_PRIZE
                + result.getOrDefault(RANK.SECOND, 0) * SECOND_PRIZE
                + result.getOrDefault(RANK.THIRD, 0) * THIRD_PRIZE
                + result.getOrDefault(RANK.FOURTH, 0) * FOURTH_PRIZE
                + result.getOrDefault(RANK.FIFTH, 0) * FIFTH_PRIZE;
        return sum / initCost * 100;
    }

    public void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (%,d원) - %d개%n",FIFTH_PRIZE, get(FIFTH));
        System.out.printf("4개 일치 (%,d원) - %d개%n",FOURTH_PRIZE, get(FOURTH));
        System.out.printf("5개 일치 (%,d원) - %d개%n",THIRD_PRIZE, get(THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (%,d원) - %d개%n",SECOND_PRIZE, get(SECOND));
        System.out.printf("6개 일치 (%,d원) - %d개%n",FIRST_PRIZE, get(FIRST));
        System.out.printf("총 수익률은 %.1f%%입니다.%n", getRate());
    }
}
