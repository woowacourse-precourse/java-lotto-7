package lotto;

public class LottoPrice {
    private final Integer lottoPrice;

    private LottoPrice(Integer lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public static LottoPrice valueOf(Integer lottoPrice) {
        validate(lottoPrice);
        return new LottoPrice(lottoPrice);
    }

    private static void validate(Integer value) {
        if(isDividableByThousand(value)) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000의 배수인 양의 정수를 입력해야 합니다.");
        }

        if(isNonNegative(value)) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000의 배수인 양의 정수를 입력해야 합니다.");
        }
    }

    private static boolean isNonNegative(Integer value) {
        return value > 0;
    }

    private static boolean isDividableByThousand(Integer value) {
        return value % 1000 != 0;
    }

    public Integer getValue() {
        return lottoPrice;
    }
}
