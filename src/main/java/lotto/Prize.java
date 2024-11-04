package lotto;

import java.util.Arrays;

public enum Prize {
    THREE(5, 3, "5,000"),
    FOUR(4, 4, "50,000"),
    FIVE(3, 5, "1,500,000"),
    BONUS(2, 5, "30,000,000"),
    SIX(1, 6, "2,000,000,000");

    private final int rank;
    private final int matchNumbers;
    private final String prizeMoney;

    Prize(int rank, int matchNumbers, String prizeMoney) {
        this.rank = rank;
        this.matchNumbers = matchNumbers;
        this.prizeMoney = prizeMoney;
    }

    public static Prize checkByMatchNum(int numberOfMatch) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchNumbers == numberOfMatch)
                .findFirst()
                .orElse(null);
    }

    public static Prize checkByRank(int rankNum) {
        return Arrays.stream(values())
                .filter(prize -> prize.rank == rankNum)
                .findFirst()
                .orElse(null);
    }

    public int getRank() {
        return rank;
    }

    public int getMatchNumbers () {
        return matchNumbers;
    }

    public String getMoney () {
        return prizeMoney;
    }

    public double money () {
        return Double.parseDouble(prizeMoney.replace(",", ""));
    }
}
