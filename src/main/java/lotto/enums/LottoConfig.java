package lotto.enums;

public enum LottoConfig {
    WOOWA_CONFIG(
            1, 45, 1_000, 6,
            1_000, 1_000_000_000, ","
    );

    private int lottoNumberMin;
    private int lottoNumberMax;
    private int lottoPrice;
    private int lottoNumberCount;
    private int lottoPurchasePriceMin;
    private int lottoPurchasePriceMax;
    private String numbersDelimiter;

    LottoConfig(
            int lottoNumberMin,
            int lottoNumberMax,
            int lottoPrice,
            int lottoNumberCount,
            int lottoPurchasePriceMin,
            int lottoPurchasePriceMax,
            String numbersDelimiter
    ) {
        this.lottoNumberMin = lottoNumberMin;
        this.lottoNumberMax = lottoNumberMax;
        this.lottoPrice = lottoPrice;
        this.lottoNumberCount = lottoNumberCount;
        this.lottoPurchasePriceMin = lottoPurchasePriceMin;
        this.lottoPurchasePriceMax = lottoPurchasePriceMax;
        this.numbersDelimiter = numbersDelimiter;
    }

    public int getLottoNumberMin() {
        return lottoNumberMin;
    }

    public int getLottoNumberMax() {
        return lottoNumberMax;
    }

    public int getLottoPrice() {
        return lottoPrice;
    }

    public int getLottoNumberCount() {
        return lottoNumberCount;
    }

    public int getLottoPurchasePriceMin() {
        return lottoPurchasePriceMin;
    }

    public int getLottoPurchasePriceMax() {
        return lottoPurchasePriceMax;
    }

    public String getNumbersDelimiter() {
        return numbersDelimiter;
    }
}
