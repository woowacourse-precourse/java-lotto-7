package lotto.constants;

import java.util.Arrays;

public enum Statistics {
//    3개 일치 (5,000원) - 1개
//4개 일치 (50,000원) - 0개
//5개 일치 (1,500,000원) - 0개
//5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
//6개 일치 (2,000,000,000원) - 0개
//    총 수익률은 62.5%입니다.
    THREE(3, 5000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private final int matching;
    private final long prize;

    Statistics(int matching, long prize) {
        this.matching = matching;
        this.prize = prize;
    }
//
//    public static Statistics getRank(int number) {
//        return Arrays.stream(values())
//                .filter(statistic -> statistic.matching == number)
//                .findFirst()
//                .orElseThrow(new IllegalArgumentException("일치하는 번호가 3미만입니다."));
//    }
}
