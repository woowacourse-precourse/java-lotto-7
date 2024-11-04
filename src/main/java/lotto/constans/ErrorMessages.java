package lotto.constans;

import static lotto.constans.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.constans.LottoConstants.MIN_LOTTO_NUMBER;
import static lotto.constans.LottoConstants.REQUIRED_LOTTO_NUMBER_COUNT;

public class ErrorMessages {
    public static final String ERROR_INVALID_RANGE =
            "로또 번호는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + "까지 입니다.";
    public static final String ERROR_INVALID_COUNT = "로또 번호는 " + REQUIRED_LOTTO_NUMBER_COUNT + "개여야 합니다.";
    public static final String ERROR_DUPLICATE_NUMBERS = "당첨 번호에 중복된 숫자가 포함될 수 없습니다.";

    public static final String ERROR_INVALID_UNIT_AMOUNT = "로또 구입 금액은 1,000원 단위로 입력해야 합니다.";
    public static final String ERROR_MINIMUM_PURCHASE_AMOUNT = "최소 구입 금액은 1,000원 입니다.";
    public static final String ERROR_MAXIMUM_PURCHASE_AMOUNT = "최대 구입 금액은 100,000원 입니다.";

    public static final String ERROR_DUPLICATE_BONUS_NUMBER = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String ERROR_BONUS_NUMBER_RANGE =
            "보너스 번호는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + " 사이의 숫자로 입력해야 합니다.";

    public static final String ERROR_NON_NUMERIC_INPUT = "입력에 숫자가 아닌 값이 포함되어 있습니다.";

    public static final String ERROR_EMPTY_AMOUNT = "금액을 입력해 주세요.";
    public static final String ERROR_NON_NUMERIC_AMOUNT = "금액은 숫자만 입력할 수 있습니다.";
}
