package lotto.domain;

public enum LottoPrice {

    THREE(3, false, 5000),
    FOUR(4, false, 50000),
    FIVE(5, false, 1500000),
    FIVE_BONUS(5, true, 30000000),
    SIX(6, false, 2000000000);

    private static final int ZERO_PRICE = 0;

    private final int lottoCount;
    private final boolean isBonus;
    private final int lottoPrice;


    LottoPrice(int lottoCount, boolean isBonus, int lottoPrice) {
        this.lottoCount = lottoCount;
        this.isBonus = isBonus;
        this.lottoPrice = lottoPrice;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public int getLottoPrice() {
        return lottoPrice;
    }

    public boolean isSameLottoPrice(int lottoPrice) {
        return this.lottoPrice == lottoPrice;
    }

    public static int getByLottoCount(int lottoCount, boolean isBonus) {
        for (LottoPrice price : values()) {
            if (isSameCount(lottoCount, isBonus, price)) {
                return price.lottoPrice;
            }
        }

        return ZERO_PRICE;
    }

    private static boolean isSameCount(int lottoCount, boolean isBonus, LottoPrice price) {
        return price.lottoCount == lottoCount && price.isBonus == isBonus;
    }
}
