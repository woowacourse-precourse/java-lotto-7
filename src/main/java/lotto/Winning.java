package lotto;

public enum Winning {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    NoMatch(0, 0, false);

    private final int numberMatches;
    private final int winnings;
    private final boolean correctBonusBall;

    Winning(int numberMatches, int winnings, boolean correctBonusBall) {
        this.numberMatches = numberMatches;
        this.winnings = winnings;
        this.correctBonusBall = correctBonusBall;
    }

    public static Winning getWinningByMatch(int matches, boolean bonusMatch) {
        for (Winning win : values()) {
            if (win.numberMatches == matches && win.correctBonusBall == bonusMatch) {
                return win;
            }
        }
        return NoMatch;
    }

    public int getWinnings() {
        return winnings;
    }

    public int getNumberMatches() {
        return this.numberMatches;
    }
}
