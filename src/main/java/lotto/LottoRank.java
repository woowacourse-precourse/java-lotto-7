package lotto;

import static console.Input.MATCH;
import static console.Input.MATCH_BONUS_BALL;
import static console.Input.NUMBER;
import static console.Input.WON;

public enum LottoRank {

    FIRST(1, 2000000000, 6),
    SECOND(2, 30000000, 5),
    THIRD(3, 1500000, 5),
    FOURTH(4, 50000, 4),
    FIFTH(5, 5000, 3);


    private final int rank;
    private final long prizeAmount;
    private final int matchNumber;
    public static final LottoRank[] LOTTO_RANKS = LottoRank.values();

    LottoRank(int rank, long prizeAmount, int matchNumber) {
        this.rank = rank;
        this.prizeAmount = prizeAmount;
        this.matchNumber = matchNumber;
    }

    public int getRank() {
        return rank;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public void printRank(long count) {
        StringBuilder message = new StringBuilder();
        message.append("%d" + MATCH);
        if (this == SECOND) {
            message.append(MATCH_BONUS_BALL);
        }
        message.append(" (%,d" + WON + ") - %d" + NUMBER + "%n");
        System.out.printf(message.toString(), matchNumber, prizeAmount, count);
    }

    public long countPrize(long count) {
        printRank(count);
        return prizeAmount * count;
    }
}
