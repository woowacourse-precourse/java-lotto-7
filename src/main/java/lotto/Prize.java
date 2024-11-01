package lotto;

import java.util.Arrays;

public enum Prize {
    ONE(6, false, 2_000_000_000),
    TWO(5, true, 30_000_000),
    THREE(5, false, 1_500_000),
    FOUR(4, false, 50_000),
    FIVE(3, false, 5_000),
    NOTHING(0, false, 0);

    private static final String INVALID_PRIZE = "[ERROR] : 상금 매칭 오류";

    private int rank;
    private boolean hasBonusNumber;
    private int price;

    Prize(int rank, boolean hasBonusNumber, int price) {
        this.rank = rank;
        this.hasBonusNumber = hasBonusNumber;
        this.price = price;
    }

    public static Prize valueOf(int rank, boolean hasBonusNumber) {

        return Arrays.stream(values())
                .filter(value -> value.getRank() == rank && value.isHasBonusNumber() == hasBonusNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_PRIZE));
    }

    public int getRank() {
        return rank;
    }

    public boolean isHasBonusNumber() {
        return hasBonusNumber;
    }

    public int getPrice() {
        return price;
    }

}
