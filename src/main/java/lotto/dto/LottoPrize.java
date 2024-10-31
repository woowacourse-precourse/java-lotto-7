package lotto.dto;

public enum LottoPrize {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    BONUS(5, 30000000);

    private final int count;
    private final int price;

    LottoPrize(int count, int price) {
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
