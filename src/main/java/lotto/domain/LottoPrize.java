package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoPrize {

    FIFTH_PRIZE(3, 0, 5000, "3개 일치 (5,000원)"),
    FOURTH_PRIZE(4, 0, 50000, "4개 일치 (50,000원)"),
    THIRD_PRIZE(5, 0, 1500000, "5개 일치 (1,500,000원)"),
    SECOND_PRIZE(5, 1, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FRIST_PRIZE(6, 0, 2000000000, "6개 일치 (2,000,000,000원)"),
    ;

    private final int numberMatch;
    private final int bonusNumberMatch;
    public final int prizeMoney;
    public final String description;

    LottoPrize(int numberMatch, int bonusNumberMatch, int prizeMoney, String description) {
        this.numberMatch = numberMatch;
        this.bonusNumberMatch = bonusNumberMatch;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }
}
