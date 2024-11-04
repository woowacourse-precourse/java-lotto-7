package lotto.model;

import lotto.constants.view.OutputViewMessage;

import java.text.NumberFormat;
import java.util.Arrays;

public enum Winning {

    NO_WIN      ("0", false, 0),
    FIRST_PLACE ("6", false, 2000000000),
    SECOND_PLACE("5", true,  30000000),
    THIRD_PLACE ("5", false, 1500000),
    FOURTH_PLACE("4", false, 50000),
    FIFTH_PLACE ("3", false, 5000);

    private final String winningNumberMatch;
    private final boolean isMatchBonusNumber;
    private final long prizeMoney;
    private long count = 0;

    Winning(String winningNumberMatch, boolean isMatchBonusNumber, long prizeMoney) {
        this.winningNumberMatch = winningNumberMatch;
        this.isMatchBonusNumber = isMatchBonusNumber;
        this.prizeMoney = prizeMoney;
    }

    public static Winning getPlaceByMatch(int winningNumberMatch, boolean isMatchBonusNumber) {
        return Arrays.stream(Winning.values())
                .filter(winning -> winning.isMatch(
                        String.valueOf(winningNumberMatch),
                        isMatchBonusNumber
                ))
                .findFirst()
                .orElse(Winning.NO_WIN);
    }

    public String toString() {
        if (this != Winning.NO_WIN) {
            return makeString();
        }
        return "";
    }

    public void increaseCount() {
        count += 1;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public void clear() {
        count = 0;
    }

    public long getCount() {
        return count;
    }

    private boolean isMatch(String winningNumberMatch, boolean isMatchBonusNumber) {
        return this.winningNumberMatch.equals(winningNumberMatch)
                && this.isMatchBonusNumber == isMatchBonusNumber;
    }

    private String makeString() {
        if (isMatchBonusNumber) {
            return makeUpFormat(OutputViewMessage.SECOND_PLACE_RESULT_MESSAGE);
        }
        return makeUpFormat(OutputViewMessage.EXCEPT_SECOND_PLACE_RESULT_MESSAGE);
    }

    private String makeUpFormat(String format) {
        return String.format(
                format,
                winningNumberMatch,
                NumberFormat.getInstance().format(prizeMoney),
                count
        );
    }
}
