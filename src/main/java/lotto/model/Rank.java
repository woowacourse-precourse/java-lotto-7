package lotto.model;

public record Rank(int matchCount, boolean isBonusMatched) {
    public boolean matches(int sameNumberCount, boolean matchBonusNumber) {
        return this.matchCount == sameNumberCount &&
                this.isBonusMatched == matchBonusNumber;
    }
}
