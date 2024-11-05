package lotto.constants;

import static lotto.constants.NumberConstants.LOTTO_END_NUM;
import static lotto.constants.NumberConstants.LOTTO_START_NUM;

public class ExceptionMessages {

    public static final String ILLEGAL_INPUT_READ = "[ERROR] 잘못된 입력입니다.";
    public static final String ILLEGAL_NUMBER_FORMAT = "[ERROR] 잘못된 숫자 형식입니다.";
    public static final String EMPTY_WINNING_NUMBER_INPUT = "[ERROR] 당첨 번호를 입력해야 합니다.";
    public static final String LOTTO_COUNT_OUT_OF_RANGE = "[ERROR] 로또는 한 장 이상, 백 장 이하로 구매할 수 있습니다.";
    public static final String BUY_AMOUNT_HAS_CHANGE = "[ERROR] 로또 가격으로 나누어 떨어지지 않습니다.";
    public static final String LOTTO_NUMBER_COUNT_OUT_OF_RANGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String DUPLICATED_LOTTO_NUMBER = "[ERROR] 로또 번호는 중복이 없어야 합니다.";
    public static final String LOTTO_NUMBER_OUT_OF_RANGE =
            "[ERROR] 로또 번호의 숫자 범위는 " + LOTTO_START_NUM + "부터 " + LOTTO_END_NUM + "까지입니다.";
    public static final String BONUS_NUMBER_OUT_OF_RANGE =
            "[ERROR] 보너스 번호의 숫자 범위는 " + LOTTO_START_NUM + "부터 " + LOTTO_END_NUM + "까지입니다.";
    public static final String BONUS_NUMBER_DUPLICATED_LOTTO_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

}
