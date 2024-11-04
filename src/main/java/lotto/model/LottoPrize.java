package lotto.model;

public enum LottoPrize {
    NOTHING(0, "Nothing"),
    FIFTH(5000, "3개 일치 (5,000원)"),
    FOURTH(50000, "4개 일치 (50,000원)"),
    THIRD(1500000, "5개 일치 (1,500,000원)"),
    SECOND(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(2000000000, "6개 일치 (2,000,000,000원)");

    private final long prize;
    private final String info;

    LottoPrize(long prize, String info) {
        this.prize = prize;
        this.info = info;
    }

    public static LottoPrize from(int count) {
        if (count == 6) return FIRST;
        if (count == 5) return THIRD;
        if (count == 4) return FOURTH;
        if (count == 3) return FIFTH;
        return NOTHING;
    }

    public long prize() {
        return prize;
    }

    public String info() {
        return info;
    }
}
