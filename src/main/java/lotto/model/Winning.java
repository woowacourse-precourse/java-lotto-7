package lotto.model;

import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public enum Winning {
    NONE(0, "불일치", 0),
    THREE(3, "3개 일치 (5,000원)", 5000),
    FOUR(4, "4개 일치 (50,000원)", 50000),
    FIVE(5, "5개 일치 (1,500,000원)", 1500000),
    FIVE_BONUS(5, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    SIX(6, "6개 일치 (2,000,000,000원)", 2000000000);

    private final int value;
    private final String message;
    private final long price;
    private int count;

    Winning(int value, String message, long price) {
        this.value = value;
        this.message = message;
        this.price = price;
    }

    public static void initCount() {
        Arrays.stream(values()).forEach(winning -> winning.count = 0);
    }

    public int getValue() {
        return value;
    }

    public static Winning getFromValue(int value, boolean isBonus) {
        Winning getWinning = Arrays.stream(values())
                .filter(winning -> winning.getValue() == value)
                .findAny()
                .orElse(NONE);
        if (validateFiveWithBonus(isBonus, value)) {
            return FIVE_BONUS;
        }
        return getWinning;
    }

    private static boolean validateFiveWithBonus(boolean isBonus, int value) {
        return value == FIVE.value && isBonus;
    }

    public int increaseCount() {
        return ++count;
    }

    public static String toStringWithoutNone() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(values())
                .filter(winning -> winning != NONE)
                .forEach(winning -> sb.append(winning.toStringBuilder()));
        return sb.toString();
    }

    private StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder();
        return sb.append(message)
                .append(" - ")
                .append(count)
                .append("개\n");
    }
    
    private BigDecimal multiplyCount() {
        return new BigDecimal(count * price);
    }

    public static AtomicReference<BigDecimal> getTotalWinningPrice() {
        AtomicReference<BigDecimal> totalWinningPrice = new AtomicReference<>(ZERO);
        Arrays.stream(values())
                .filter(winning -> winning != NONE)
                .forEach(winning -> {
                    totalWinningPrice.updateAndGet(p -> p.add(winning.multiplyCount()));
                });
        return totalWinningPrice;
    }
}