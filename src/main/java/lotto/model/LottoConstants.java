package lotto.model;

public class LottoConstants {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final String INVALID_NUMBER_RANGE_ERROR_MESSAGE =
            "로또 숫자는 " + MIN_LOTTO_NUMBER + " 이상 " + MAX_LOTTO_NUMBER + " 이하입니다.";

    private LottoConstants() {
        
    }
}