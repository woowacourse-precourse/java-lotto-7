package lotto.model;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoRank {

    NONE(0, 0, (matchedCount, bonusNumber) -> matchedCount < 3),
    FIFTH(3, 5_000, (matchedCount, bonusNumber) -> matchedCount == 3),
    FOURTH(4, 50_000, (matchedCount, bonusNumber) -> matchedCount == 4),
    THIRD(5, 1_500_000, (matchedCount, bonusNumber) -> matchedCount == 5 && !bonusNumber),
    SECOND(5, 30_000_000, (matchedCount, bonusNumber) -> matchedCount == 5 && bonusNumber),
    FIRST(6, 2_000_000_000, (matchedCount, bonusNumber) -> matchedCount == 6);

    private static final String DEFAULT_RESULT_MESSAGE = "%d개 일치 (%,d원)";
    private static final String BONUS_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원)";

    private final int matchCount;
    private final int prize;
    private final BiPredicate<Integer, Boolean> condition;

    LottoRank(int matchCount, int prize, BiPredicate<Integer, Boolean> condition) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.condition = condition;
    }

    public static LottoRank from(final int matchedCount, final boolean bonusNumber) {
        return Arrays.stream(values())
                .filter(rank -> rank.condition.test(matchedCount, bonusNumber))
                .findFirst()
                .orElse(NONE);
    }

    public BigInteger calculatePrizeByCount(final int count) {
        BigInteger total = BigInteger.valueOf(this.prize);
        return total.multiply(BigInteger.valueOf(count));
    }

    public String getResultMessage() {
       if (this == SECOND) {
           return getFormattedResultMessage(BONUS_RESULT_MESSAGE);
       }
       return getFormattedResultMessage(DEFAULT_RESULT_MESSAGE);
    }

    private String getFormattedResultMessage(String message) {
        return String.format(message, this.matchCount, this.prize);
    }
}
