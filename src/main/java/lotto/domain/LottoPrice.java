package lotto.domain;

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
        return valueOf(Integer.parseInt(lottoPriceString));
    }

    private static void validate(Integer value) {

        isDividableByThousand(value);
        isNonNegative(value);
    }

    private static void isNonNegative(Integer value) {
        if(value < 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000의 배수인 양의 정수를 입력해야 합니다.");
        }
    }

    private static void isDividableByThousand(Integer value) {
        if(value % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000의 배수인 양의 정수를 입력해야 합니다.");
        }
    }

    public Integer getValue() {
        return lottoPrice;
    }

    public Integer getTotalLottoCount() {
        return lottoPrice / 1000;
    }
}
