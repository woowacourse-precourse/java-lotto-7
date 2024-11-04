package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoRank {
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50000, "4개 일치 (50,000원)"),
    FIFTH(3, 5000, "3개 일치 (5,000원)"),
    NOT_YOUR_DAY(0, 0, "꽝");

    private final int matchCount;
    private final int prize;
    private final String message;

    LottoRank(int matchCount, int prize, String message) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.message = message;
    }

    public static LottoRank findLottoRankByMatchCountAndBonus(int matchCount, boolean matchBonus) {
        if (matchCount < FIFTH.matchCount) {
            return NOT_YOUR_DAY;
        }
        if (matchCount == FIFTH.matchCount) {
            return FIFTH;
        }
        if (matchCount == FOURTH.matchCount) {
            return FOURTH;
        }
        if (matchCount == THIRD.matchCount && !matchBonus) {
            return THIRD;
        }
        if (matchCount == SECOND.matchCount) {
            return SECOND;
        }
        return FIRST;
    }

    public static Map<LottoRank, Integer> createLottoResultForm() {
        Map<LottoRank, Integer> lottoResultForm = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            lottoResultForm.put(rank, 0);
        }
        return lottoResultForm;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
