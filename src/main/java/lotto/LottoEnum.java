package lotto;

public enum LottoEnum {
    FIRST(7, 2000000000, 0),
    SECOND(6, 30000000, 0),
    THIRD(5, 1500000, 0),
    FOURTH(4, 50000, 0),
    FIFTH(3, 5000, 0),
    NONE(0, 0,0);


    private final int matchCount;
    private final int prizeAmount;
    private int winnerCount;

    LottoEnum(int matchCount, int prizeAmount, int winnerCount) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.winnerCount = winnerCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public int getWinnerCount() {
        return winnerCount;
    }

    public static int getPrizeByMatchCount(int count) {
        for(LottoEnum lotto : LottoEnum.values()) {
            if(lotto.matchCount == count) {
                return lotto.getPrizeAmount();
            }
        }
        return 0;
    }

    public static void increaseWinnerCount(int count) {
        for(LottoEnum lotto : LottoEnum.values()) {
            if(lotto.matchCount == count) {
                lotto.winnerCount++;
            }
        }
    }

    public static int getWinnerCount(int count) {
        for(LottoEnum lotto : LottoEnum.values()) {
            if(lotto.matchCount == count) {
                return lotto.getWinnerCount();
            }
        }
        return 0;
    }
}
