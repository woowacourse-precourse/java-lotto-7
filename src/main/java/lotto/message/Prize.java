package lotto.message;

import java.util.ArrayList;
import java.util.List;

public enum Prize {
    FIRST_PLACE(2_000_000_000),
    SECOND_PLACE(30_000_000),
    THIRD_PLACE(1_500_000),
    FOURTH_PLACE(50_000),
    FIFTH_PLACE(5_000);

    private final Integer prizeMoney;

    Prize(Integer prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public static List<Integer> getPrize() {
        List<Integer> prizes = new ArrayList<>();
        for (Prize prize : Prize.values()) {
            prizes.add(prize.prizeMoney);
        }
        return prizes;
    }
}
