package lotto;

/**
 * LottoRule
 */
public abstract class LottoRule {

    public static final int LOTTO_PRICE = 1000;
    public static final int RANGE_LOW = 1;
    public static final int RANGE_HIGH = 45;
    public static final int NUMBER_LENGTH = 6;
    public static final int[] WINNING_PRIZE_TABLE = {
        0,
        2_000_000_000,
        30_000_000,
        1_500_000,
        50_000,
        5_000
    };

    public static int getPlace(int matchCount, boolean isBonusMatch) {
        if (matchCount == 6) return 1;
        if (matchCount == 5 && isBonusMatch) return 2;
        if (matchCount == 5) return 3;
        if (matchCount == 4) return 4;
        if (matchCount == 3) return 5;
        return 0;
    }

}
