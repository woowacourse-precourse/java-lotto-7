package lotto.enums;

import java.util.List;

public enum LottoResult {
    FIRST_PLACE(2000000000, 6, 0),
    SECOND_PLACE(30000000, 5, 1),
    THIRD_PLACE(1500000, 5, 0),
    FOURTH_PLACE(50000, 4, 0),
    FIFTH_PLACE(5000, 3, 0),
    NO_PRIZE(0, null, null),;

    private final Integer prizeMoney;
    private final Integer matchCnt;
    private final Integer bonusMatchCnt;

    LottoResult(Integer prizeMoney, Integer matchCnt, Integer bonusMatchCnt) {
        this.prizeMoney = prizeMoney;
        this.matchCnt = matchCnt;
        this.bonusMatchCnt = bonusMatchCnt;
    }

    public int getBonusMatchCnt() {
        return bonusMatchCnt;
    }

    public int getMatchCnt() {
        return matchCnt;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static List<LottoResult> hasPrizeMoneyResult() {
        return List.of(FIRST_PLACE, SECOND_PLACE, THIRD_PLACE, FOURTH_PLACE, FIFTH_PLACE);
    }
}
