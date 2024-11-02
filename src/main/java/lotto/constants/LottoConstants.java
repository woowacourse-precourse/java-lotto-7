package lotto.constants;

public class LottoConstants {
    public static final int LOTTO_PRICE_BASE_UNIT = 1000;

    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private LottoConstants() {
        throw new IllegalStateException(ErrorMessageConstants.INSTANCE_CREATION_ERROR);
    }
}
