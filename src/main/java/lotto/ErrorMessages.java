package lotto;

import static lotto.Constants.LOTTO_UNIT;

public class ErrorMessages {
    public static final String LOTTO_SIZE_WRONG = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String LOTTO_RANGE_WRONG = "[ERROR] 로또 번호가 1 ~ 45 사이의 수가 아닙니다.";
    public static final String LOTTO_NUMBER_DUPLICATE = "[ERROR] 번호가 중복되는 로또 번호가 존재합니다.";

    public static final String WINNING_LOTTO_DUPLICATE = "[ERROR] 번호가 중복되는 로또 번호가 존재합니다.";
    public static final String WINNING_LOTTO_RANGE_WRONG = "[ERROR] 로또 번호가 1 ~ 45 사이의 수가 아닙니다.";

    public static final String INPUT_MONEY_NULL = "[ERROR] 구입 금액을 입력해 주세요.";
    public static final String INPUT_MONEY_WONG = "[ERROR] 구입 금액은 숫자여야 합니다.";
    public static final String MONEY_WRONG = "[ERROR] 구입 금액은 " + LOTTO_UNIT + "원 이상이어야 합니다.";
    public static final String MONEY_UNIT_WRONG = "[ERROR] 구입 금액은 " + LOTTO_UNIT + "원 단위여야 합니다.";
}
