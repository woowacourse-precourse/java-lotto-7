package lotto.constant;

import static lotto.constant.Policy.LOTTO_NUMBER_MAX;
import static lotto.constant.Policy.LOTTO_NUMBER_MIN;
import static lotto.constant.Policy.LOTTO_PRICE;
import static lotto.constant.Policy.LOTTO_SIZE;

public class ExceptionMessage {

    public static final String EXCEPTION_PREFIX = "[ERROR] ";
    public static final String INPUT_EMPTY = "입력값은 비어있을 수 없습니다.";
    public static final String LOTTO_NUMBER_INVALID_RANGE =
            "로또 번호가 올바르지 않습니다.\n로또 번호는 " + LOTTO_NUMBER_MIN + "이상 " + LOTTO_NUMBER_MAX + "이하입니다.";
    public static final String LOTTO_INVALID_SIZE = "로또 번호는 " + LOTTO_SIZE + "개여야 합니다.";
    public static final String LOTTO_NUMBER_DUPLICATED = "로또 번호는 중복될 수 없습니다.";
    public static final String PURCHASE_AMOUNT_MUST_LONG = "구입 금액은 Long 타입이여야 합니다.";
    public static final String PURCHASE_AMOUNT_LOTTO_PRICE_DIVISIBILITY = "구입 금액은 " + LOTTO_PRICE + "으로 나누어떨어져야 합니다.";
    public static final String PURCHASE_AMOUNT_NOT_NEGATIVE = "구입 금액은 음수가 될 수 없습니다.";
    public static final String PURCHASE_AMOUNT_IS_POSITIVE = "구입 금액은 양수여야 합니다.";
    public static final String PURCHASE_AMOUNT_NOT_SETTING = "구입금액을 먼저 설정해주세요.";
    public static final String WINNER_NUMBER_INPUT_INVALID_CHARACTER = "당첨 숫자 입력은 숫자와 쉼표로만 이루어져야 합니다.";
    public static final String WINNER_NUMBER_INVALID_COMMA_POSITION = "당첨 숫자의 콤마(,) 앞 뒤에는 숫자가 있어야 합니다.";
    public static final String BONUS_NUMBER_MUST_INTEGER = "보너스 번호는 Integer 타입이여야 합니다.";
    public static final String BONUS_NUMBER_DUPLICATED = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

}
