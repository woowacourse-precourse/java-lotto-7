package lotto;

public enum EnumLottoPrice {
    MATCH_3(3, 5_000),
    MATCH_4(4, 50_000),
    MATCH_5(5, 1_500_000),
    MATCH_5_EXCEPT_BONUS(5, 30_000_000),
    MATCH_6(6, 2_000_000_000);

    private final int numberMatchCount;
    private final int price;

    EnumLottoPrice(int numberMatchCount, int price) {
        this.numberMatchCount = numberMatchCount;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
