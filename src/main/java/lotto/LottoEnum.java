package lotto;

import java.math.BigDecimal;
import java.util.Arrays;

import static lotto.Constant.*;

public enum LottoEnum {
    FIFTH(3, new BigDecimal(5000), new BigDecimal(0)),
    FOURTH(4, new BigDecimal(50000), new BigDecimal(0)),
    THIRD(5, new BigDecimal(1500000), new BigDecimal(0)),
    SECOND(LOTTO_BONUS_HIT, new BigDecimal(30000000), new BigDecimal(0)),
    FIRST(6, new BigDecimal(2000000000), new BigDecimal(0)),
    NONE(0, new BigDecimal(0), new BigDecimal(0));


    private final int matchCount;
    private final BigDecimal prize;
    private BigDecimal winnerCount;

    LottoEnum(int matchCount, BigDecimal prize, BigDecimal winnerCount) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.winnerCount = winnerCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public BigDecimal getWinnerCount() {
        return winnerCount;
    }

    public static void increaseWinnerCount(int count) {
        Arrays.stream(LottoEnum.values())
                .filter(lotto -> lotto.matchCount == count)
                .forEach(lotto -> lotto.winnerCount = lotto.winnerCount.add(BigDecimal.valueOf(1)));
    }

    public static BigDecimal sum() {
        BigDecimal totalPrize = new BigDecimal(0);
        for (LottoEnum lotto : LottoEnum.values()) {
            totalPrize = totalPrize.add(lotto.getWinnerCount().multiply(lotto.getPrize()));
        }
        return totalPrize;
    }
}
