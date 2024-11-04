package lotto.domain;

import lotto.exceptions.LottoInvalidMatchException;
import org.junit.platform.commons.util.StringUtils;

import static lotto.utils.LottoValidator.BONUS_MATCH_INTERSECTION_NUMBER;

public enum LottoWinningTable {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000);
    private final int matchCount;
    private final int reward;
    private final boolean hasBonus;

    LottoWinningTable(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.hasBonus = false;
    }

    LottoWinningTable(int matchCount, int reward, boolean hasBonus) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.hasBonus = hasBonus;
    }

    public static LottoWinningTable findByMatchCount(int target) {
        if (target == BONUS_MATCH_INTERSECTION_NUMBER) {
            throw new LottoInvalidMatchException();
        }
        for (LottoWinningTable value : LottoWinningTable.values()) {
            if (value.getMatchCount() == target) {
                return value;
            }
        }
        throw new LottoInvalidMatchException();
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getReward() {
        return this.reward;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(matchCount).append("개 일치");
        if(hasBonus) sb.append(", 보너스 볼 일치");
        sb.append(" (").append(String.format("%,d", reward)).append("원)");
        return sb.toString();
    }
}
