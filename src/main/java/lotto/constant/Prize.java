package lotto.constant;

public enum Prize {
    NONE(0, 0, false, null),
    FIFTH(3, 5_000, false, "3개 일치 (5,000원) - %d개"),
    FOURTH(4, 50_000, false, "4개 일치 (50,000원) - %d개"),
    THIRD(5, 1_500_000, false, "5개 일치 (1,500,000원) - %d개"),
    SECOND(5, 30_000_000, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(6, 2_000_000_000, false, "6개 일치 (2,000,000,000원) - %d개");

    private final int match;
    private final int money;
    private final boolean bonus;
    private final String message;

    Prize(int match, int money, boolean bonus, String message) {
        this.match = match;
        this.money = money;
        this.bonus = bonus;
        this.message = message;
    }

    public int getMoney() {
        return money;
    }

    public String getMessage() {
        return message;
    }

    public static Prize getPrize(int match, boolean bonus) {
        for (Prize prize : values()) {
            if (prize.match == match && prize.bonus == bonus) {
                return prize;
            }
        }
        return NONE;
    }
}
