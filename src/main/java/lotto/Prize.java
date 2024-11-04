package lotto;

public enum Prize {
    PRIZE_1(2000000000),
    PRIZE_2(30000000),
    PRIZE_3(1500000),
    PRIZE_4(50000),
    PRIZE_5(5000);

    private final int prize;

    Prize(int prize) {
        this.prize = prize;
    }

    public int prize() {
        return prize;
    }
}
