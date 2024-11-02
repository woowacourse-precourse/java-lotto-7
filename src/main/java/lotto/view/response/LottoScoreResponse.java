package lotto.view.response;

import java.util.Objects;

public class LottoScoreResponse {

    private final int matchCount;
    private final boolean containsBonus;
    private final int prize;

    private LottoScoreResponse(int matchCount, boolean containsBonus, int prize) {
        this.matchCount = matchCount;
        this.containsBonus = containsBonus;
        this.prize = prize;
    }

    public static LottoScoreResponse from(int matchCount, boolean isBonusMatch, int prize) {
        return new LottoScoreResponse(matchCount, isBonusMatch, prize);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean containsBonus() {
        return containsBonus;
    }

    public int getPrize() {
        return prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoScoreResponse that)) {
            return false;
        }
        return matchCount == that.matchCount && containsBonus == that.containsBonus && prize == that.prize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, containsBonus, prize);
    }
}
