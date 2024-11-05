package lotto.mvc.model;

import java.math.BigInteger;
import java.util.function.Function;

public enum LottoWinningAmount {
    THREE(3, 5_000, "3개 일치", count -> count.multiply(BigInteger.valueOf(5_000))),
    FOUR(4, 50_000, "4개 일치", count -> count.multiply(BigInteger.valueOf(50_000))),
    FIVE(5, 1_500_000, "5개 일치", count -> count.multiply(BigInteger.valueOf(1_500_000))),
    FIVE_PLUS_BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치",
            count -> count.multiply(BigInteger.valueOf(30_000_000)), true),
    SIX(6, 2_000_000_000, "6개 일치", count -> count.multiply(BigInteger.valueOf(2_000_000_000)));

    private int count;
    private int prizeAmount;
    private boolean bonus;
    private String description;
    private Function<BigInteger, BigInteger> prizeCalculator;

    LottoWinningAmount(int count, int amount, String description, Function<BigInteger, BigInteger> prizeCalculator) {
        this(count, amount, description, prizeCalculator, false);
    }

    LottoWinningAmount(int count, int amount, String description, Function<BigInteger, BigInteger> prizeCalculator,
                       boolean bonus) {
        this.count = count;
        this.prizeAmount = amount;
        this.description = description;
        this.prizeCalculator = prizeCalculator;
        this.bonus = bonus;
    }

    public int getCount() {
        return count;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public boolean isBonus() {
        return bonus;
    }

    public String getDescription() {
        return description;
    }

    public BigInteger calculatePrize(int count) {
        return prizeCalculator.apply(BigInteger.valueOf(count));
    }
}
