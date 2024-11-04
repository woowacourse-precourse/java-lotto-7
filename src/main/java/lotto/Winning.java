package lotto;

import java.util.stream.Stream;

public enum Winning {
    FIFTH(3, 5000, "5,000"),
    FOURTH(4, 50000, "50,000"),
    THIRD(5, 1500000, "1,500,000"),
    SECOND(5, 30000000, "30,000,000"),
    FIRST(6, 2000000000, "2,000,000,000");

    private final int match;
    private final int money;
    private final String commaMoney;
    private int count;

    Winning(int match, int money, String commaMoney) {
        this.match = match;
        this.money = money;
        this.commaMoney = commaMoney;
    }

    public void count() {
        this.count++;
    }

    public int getCount() {
        return count;
    }

    public static Winning findByMatch(int match) {
        return Stream.of(values())
                .filter(winning -> winning.match == match)
                .findFirst()
                .orElseThrow();
    }
}
