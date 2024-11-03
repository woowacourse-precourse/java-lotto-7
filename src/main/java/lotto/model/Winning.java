package lotto.model;

import java.text.NumberFormat;
import java.util.Arrays;

public enum Winning {

    NO_WIN      (0, "0", false, 0),
    FIRST_PLACE (1, "6", false, 2000000000),
    SECOND_PLACE(2, "5", true, 30000000),
    THIRD_PLACE (3, "5", false, 1500000),
    FOURTH_PLACE(4, "4", false, 50000),
    FIFTH_PLACE (5, "3", false, 5000);

    private final int rank;
    private final String winningNumberMatch;
    private final boolean isMatchBonusNumber;
    private final long prizeMoney;
    private long count = 0;

    Winning(int rank, String winningNumberMatch, boolean isMatchBonusNumber, long prizeMoney) {
        this.rank = rank;
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

    public static Winning getPlaceByRank(int rank) {
        return Arrays.stream(Winning.values())
                .filter(winning -> winning.rank == rank)
                .findFirst()
                .orElse(Winning.NO_WIN);
    }

    public String toString() {
        if (this != Winning.NO_WIN) {
            StringBuilder sb = new StringBuilder();
            makeString(sb);
            return sb.toString();
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

    private void makeString(StringBuilder sb) {
        sb.append(winningNumberMatch)
                .append("개 일치");
        if (isMatchBonusNumber) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" (")
                .append(NumberFormat.getInstance().format(prizeMoney))
                .append("원) - ")
                .append(count)
                .append("개\n");
    }
}
