package lotto.model;

import java.util.stream.Stream;

public enum Prize {
    NONE(0, 0, "없음"),
    THREE(3, 5_000, "3개 일치 (5,000원)"),
    FOUR(4, 50_000, "4개 일치 (50,000원)"),
    FIVE(5, 1_500_000, "5개 일치 (1,500,000원)"),
    BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX(6, 2_000_000_000, "6개 일치 (2,000,000,000원)");

    private final int match;
    private final int money;
    private final String message;

    Prize(int match, int money, String message) {
        this.match = match;
        this.money = money;
        this.message = message;
    }

    public static Prize getPrize(int count, boolean hasBonus) {
        if (count == 5) {
            return hasBonus ? BONUS : FIVE;
        }
        return Stream.of(Prize.values())
                .filter(prize -> prize.match == count)
                .findFirst()
                .orElse(NONE);
    }

    public int getMoney() {
        return money;
    }

    public String getMessage() {
        return message;
    }
}
