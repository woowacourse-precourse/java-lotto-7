package lotto.domain;

import static lotto.domain.Constants.FIFTH_PRIZE_MATCH;
import static lotto.domain.Constants.FIRST_PRIZE_MATCH;
import static lotto.domain.Constants.FOURTH_PRIZE_MATCH;
import static lotto.domain.Constants.PRIZEMONEY1;
import static lotto.domain.Constants.PRIZEMONEY2;
import static lotto.domain.Constants.PRIZEMONEY3;
import static lotto.domain.Constants.PRIZEMONEY4;
import static lotto.domain.Constants.PRIZEMONEY5;
import static lotto.domain.Constants.SECONDTHIRD_PRIZE_MATCH;

public enum Ranking {
    FIRST(FIRST_PRIZE_MATCH, false, PRIZEMONEY1),    // 1등: 6개 번호 일치
    SECOND(SECONDTHIRD_PRIZE_MATCH, true, PRIZEMONEY2),      // 2등: 5개 번호 + 보너스 번호 일치
    THIRD(SECONDTHIRD_PRIZE_MATCH, false, PRIZEMONEY3),       // 3등: 5개 번호 일치
    FOURTH(FOURTH_PRIZE_MATCH, false, PRIZEMONEY4),        // 4등: 4개 번호 일치
    FIFTH(FIFTH_PRIZE_MATCH, false, PRIZEMONEY5);          // 5등: 3개 번호 일치

    private int matchCount;   // 일치하는 번호 개수
    private final boolean bonus;    // 보너스 번호 여부
    private final int prize;        // 상금

    Ranking(int matchCount, boolean bonus, int prize) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.prize = prize;
    }

    public int getPrize() {
        return this.prize;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public static Ranking getRank(int matchCount, boolean hasBonus) {
        for (Ranking rank : Ranking.values()) {
            if (rank.matchCount == matchCount && rank.bonus == hasBonus) {
                return rank;
            }
        }
        return null;
    }

    public boolean isBonus() {
        return bonus;
    }
}
