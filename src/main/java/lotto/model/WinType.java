package lotto.model;

import java.util.List;

public enum WinType {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE_WITHOUT_BONUS(5, 1500000),
    FIVE_WITH_BONUS(5, 30000000),
    SIX(6, 2000000000),
    ZERO(0, 0);

    public static final List<WinType> ALL_WIN_TYPES = List.of(
            THREE,
            FOUR,
            FIVE_WITHOUT_BONUS,
            FIVE_WITH_BONUS,
            SIX
    );
    private final int count;
    private final int price;

    WinType(int count, int price) {
        this.count = count;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }
}
