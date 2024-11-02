package lotto.model;

import static lotto.model.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.model.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.model.LottoConstants.MIN_LOTTO_NUMBER;

public class LottoErrorConstants {
    public static final String INVALID_NUMBER_RANGE_ERROR_MESSAGE =
            "로또 숫자는 " + MIN_LOTTO_NUMBER + "이상 " + MAX_LOTTO_NUMBER + " 이하입니다.";

    public static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "중복된 번호가 있습니다.";
    public static final String INVALID_NUMBER_COUNT_ERROR_MESSAGE = "로또 번호는 " + LOTTO_NUMBER_COUNT + "개 입니다.";

    private LottoErrorConstants() {
    }
}
