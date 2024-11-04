package lotto;

import static lotto.RANK.FIFTH;
import static lotto.RANK.FIRST;
import static lotto.RANK.FOURTH;
import static lotto.RANK.SECOND;
import static lotto.RANK.THIRD;

import java.util.HashMap;
import java.util.Map;

public class LottoService {
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
        double sum = result.getOrDefault(RANK.FIRST, 0) * 2000000000
                + result.getOrDefault(RANK.SECOND, 0) * 30000000
                + result.getOrDefault(RANK.THIRD, 0) * 1500000
                + result.getOrDefault(RANK.FOURTH, 0) * 50000
                + result.getOrDefault(RANK.FIFTH, 0) * 5000;
        return sum / initCost * 100;
    }

    public void printResult(){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", get(FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개%n", get(FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", get(THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", get(SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", get(FIRST));
        System.out.printf("총 수익률은 %.1f%%입니다.%n", getRate());
    }
}
