package lotto.enums;

public enum Prize {
    FIRST_PLACE(2000000000),
    SECOND_PLACE(30000000),
    THIRD_PLACE(1500000),
    FOURTH_PLACE(50000),
    FIFTH_PLACE(5000);
    private final long prize;

    Prize(long prize) {
        this.prize = prize;
    }

    public long getMoney() {
        return prize;
    }
}
