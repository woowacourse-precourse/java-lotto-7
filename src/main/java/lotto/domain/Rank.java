package lotto.domain;

import java.util.Arrays;
import net.bytebuddy.pool.TypePool.Empty;

public enum Rank {

    FIRST(6, false, "6개 일치 (2,000,000,000원)"),
    SECOND(5, true, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, false, "5개 일치 (1,500,000원)"),
    FOURTH(4, false, "4개 일치 (50,000원)"),
    FIFTH(3 ,false, "3개 일치 (5,000원)"),
    EMPTY(0, false, "낙첨");

    private int matchedNumberCount;
    private boolean matchedBonusNumber;
    private String description;

    Rank(int matchedNumberCount, boolean matchedBonusNumber, String description) {
        this.matchedNumberCount = matchedNumberCount;
        this.matchedBonusNumber = matchedBonusNumber;
        this.description = description;
    }

    public static Rank getRank(int matchedNumberCount, boolean isBonusMatched) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchedNumberCount() == matchedNumberCount &&
                        rank.isMatchedBonusNumber() == isBonusMatched)
                .findAny()
                .orElse(EMPTY);
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public boolean isMatchedBonusNumber() {
        return matchedBonusNumber;
    }

    public String getDescription() {
        return description;
    }
}
