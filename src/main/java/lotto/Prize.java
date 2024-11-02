package lotto;

import java.util.Arrays;

public enum Prize {
    ONE(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    TWO(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THREE(5, false, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOUR(4, false, 50_000, "4개 일치 (50,000원) - "),
    FIVE(3, false, 5_000, "3개 일치 (5,000원) - "),
    NOTHING(0, false, 0, "");

    private static final String INVALID_PRIZE = "[ERROR] : 상금 매칭 오류";

    private int rank;
    private boolean hasBonusNumber;
    private int price;
    private String message;

    Prize(int rank, boolean hasBonusNumber, int price, String message) {
        this.rank = rank;
        this.hasBonusNumber = hasBonusNumber;
        this.price = price;
        this.message = message;
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

    public String getMessage() {
        return message;
    }
}
