package lotto.view.response;

import lotto.model.Score;

import java.util.Objects;

public class LottoScoreResponse {

    private final int matchCount;
    private final boolean containsBonus;
    private final int prize;

    private LottoScoreResponse(Score score) {
        this.matchCount = score.getMatchCount();
        this.containsBonus = score.containsBonus();
        this.prize = score.getPrize();
    }

    public static LottoScoreResponse from(Score score) {
        return new LottoScoreResponse(score);
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
