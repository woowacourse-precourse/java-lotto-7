package lotto.ui;

import static lotto.domain.Constant.LOTTO_PRICE;
import static lotto.domain.Constant.MAXIMUM_LOTTO_NUMBER;
import static lotto.domain.Constant.MINIMUM_LOTTO_NUMBER;

public final class ErrorMessage {
    private static final String PREFIX = "[ERROR]";

    public static final String ERROR_TYPE_OF_MONEY = PREFIX + "올바른 형태의 금액을 입력해주세요.";
    public static final String ERROR_CONSTRAINTS_OF_MONEY= PREFIX + "입력 단위는 1000원 입니다.";
    public static final String ERROR_MINIMUM_OF_MONEY = PREFIX + "로또 구매 금액은 최소 " + LOTTO_PRICE + "입니다.";
    public static final String ERROR_INPUT_IS_NaN = PREFIX + "입력된 번호가 정수가 아닙니다.";
    public static final String ERROR_CONSTRAINTS_OF_LOTTO_NUMBER = PREFIX + "로또번호는 " + MINIMUM_LOTTO_NUMBER + "에서 " + MAXIMUM_LOTTO_NUMBER + "사이 숫자만 가능합니다.";

    public static final String ERROR_OVERLAP_BONUS_AND_WINNING = PREFIX + "당첨번호에 보너스번호가 포합되어 있습니다.";
    public static final String ERROR_OVERLAP_WINNINGS = PREFIX + "중복되는 번호가 존재합니다.";
    public static final String ERROR_CONSTRAINTS_OF_LOTTO_LENGTH = PREFIX + "로또번호는 6개로 이루어져야 합니다.";

    private ErrorMessage() {
    }
}
