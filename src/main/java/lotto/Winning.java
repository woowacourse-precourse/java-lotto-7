package lotto;

import java.util.Arrays;

public enum Winning {
    NoMatch(0, false, 0, ""),
    Match3(3, false, 5000, "3개 일치 (5,000원) - "),
    Match4(4, false, 50000, "4개 일치 (50,000원) - "),
    Match5(5, false, 1500000, "5개 일치 (1,500,000원) - "),
    Match5AndBonus(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    Match6(6, false, 2000000000, "6개 일치 (2,000,000,000원) - ");

    private final int matchCount;
    private final boolean bonusMatch;
    private final int winningAmount;
    private final String matchString;

    Winning(int matchCount, boolean bonusMatch, int winningAmount, String matchString) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.winningAmount = winningAmount;
        this.matchString = matchString;
    }

    public static Winning findByMatchCountAndBonusMatch(int matchCount, boolean bonusMatch) {
        return Arrays.stream(Winning.values())
                .filter(winning -> winning.matchCount == matchCount && winning.bonusMatch == bonusMatch)
                .findAny()
                .orElse(NoMatch);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getBonusMatch() {
        return bonusMatch;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public String getMatchString() {
        return matchString;
    }
}
