package lotto.domain.lottoPrize;

public record MatchCondition(
        int matchCount,
        boolean matchBonus
) {
    public boolean canMatchWith(int matchCount, boolean matchBonus) {
        if (this.matchBonus && !matchBonus) {
            return false;
        }
        return this.matchCount <= matchCount;
    }
}
