package lotto.constant;

import static lotto.constant.LottoSystemConstant.*;

public class ErrorMessage {

    private static final String PREFIX_ERROR_MESSAGE = "[ERROR]";

    public static final String DUPLICATE_NUMBER_INPUT = "%s 중복되지 않게 로또 번호를 입력해야 합니다."
            .formatted(PREFIX_ERROR_MESSAGE);

    public static final String DUPLICATE_BONUS_NUMBER_INPUT = "%s 당첨 번호와 중복되지 않게 보너스 번호를 입력해야 합니다."
            .formatted(PREFIX_ERROR_MESSAGE);

    public static final String INVALID_NUMBER_INPUT = "%s 올바른 로또 번호를 입력해야 합니다."
            .formatted(PREFIX_ERROR_MESSAGE);

    public static final String INVALID_PURCHASE_AMOUNT = "%s 로또 구입 금액은 %,d원 단위여야 합니다."
            .formatted(PREFIX_ERROR_MESSAGE, LOTTO_PRICE);

    public static final String INVALID_PICK_COUNT = "%s 로또 번호는 %d개여야 합니다."
            .formatted(PREFIX_ERROR_MESSAGE, LOTTO_PICK_COUNT);

    public static final String LOTTO_NUMBER_OUT_OF_BOUND = "%s 로또 번호는 %d부터 %d 사이의 숫자여야 합니다."
            .formatted(PREFIX_ERROR_MESSAGE, LOTTO_LOWER_BOUND, LOTTO_UPPER_BOUND);
}
