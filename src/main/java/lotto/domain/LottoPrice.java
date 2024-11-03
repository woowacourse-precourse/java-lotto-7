package lotto.domain;


import static lotto.enums.Error.INVALID_PRICE_INPUT;

public class LottoPrice {
    private final Integer lottoPrice;

    private LottoPrice(Integer lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public static LottoPrice valueOf(Integer lottoPrice) {
        validate(lottoPrice);
        return new LottoPrice(lottoPrice);
    }

    public static LottoPrice valueOf(String lottoPriceString) {
        try {
            return valueOf(Integer.parseInt(lottoPriceString));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_PRICE_INPUT.getMessage());
        }
    }

    private static void validate(Integer value) {

        isDividableByThousand(value);
        isNonNegative(value);
    }

    private static void isNonNegative(Integer value) {
        if(value < 0) {
            throw new IllegalArgumentException(INVALID_PRICE_INPUT.getMessage());
        }
    }

    private static void isDividableByThousand(Integer value) {
        if(value % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PRICE_INPUT.getMessage());
        }
    }

    public Integer getValue() {
        return lottoPrice;
    }

    public Integer getTotalLottoCount() {
        return lottoPrice / 1000;
    }
}
