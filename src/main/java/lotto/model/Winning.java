package lotto.model;

import java.util.Arrays;

public enum Winning {

    NO_WIN      ("0", "0", 0),
    FIFTH_PLACE ("3", "0", 5000),
    FOURTH_PLACE("4", "0", 50000),
    THIRD_PLACE ("5", "0", 1500000),
    SECOND_PLACE("5", "1", 30000000),
    FIRST_PLACE ("6", "0", 2000000000);

    private final String winningNumberMatch;
    private final String bonusNumberMatch;
    private final long prizeMoney;

    Winning(String winningNumberMatch, String bonusNumberMatch, long prizeMoney) {
        this.winningNumberMatch = winningNumberMatch;
        this.bonusNumberMatch = bonusNumberMatch;
        this.prizeMoney = prizeMoney;
    }

    public static Winning getPlace(int winningNumberMatch, int bonusNumberMatch) {
        return Arrays.stream(Winning.values())
                .filter(winning -> winning.isMatch(String.valueOf(winningNumberMatch), String.valueOf(bonusNumberMatch)))
                .findFirst()
                .orElse(Winning.NO_WIN);
    }

    private boolean isMatch(String winningNumberMatch, String bonusNumberMatch) {
        return this.winningNumberMatch.equals(winningNumberMatch) && this.bonusNumberMatch.equals(bonusNumberMatch);
    }
}
