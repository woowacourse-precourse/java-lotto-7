package lotto.common.exception;

import lotto.common.rule.Rule;

public class ExceptionName {

    private static final String PREFIX = "[ERROR] ";

    // domain 관련 exception
    public static final String LOTTO_LENGTH = PREFIX + "로또 번호는 6개여야 합니다.";
    public static final String LOTTO_NUMBER_DOMAIN =
            PREFIX + "로또 번호는 " + Rule.LOTTO_MINIMUM_NUMBER + "부터 " + Rule.LOTTO_MAXIMUM_NUMBER + "까지의 정수이어야 합니다.";
    public static final String LOTTO_NUMBER_DUPLICATE = PREFIX + "로또 번호는 중복될 수 없습니다.";
    public static final String LOTTO_RESULT_MODIFY = PREFIX + "이미 확인된 로또의 등수를 수정할 수 없습니다.";
    public static final String LOTTO_RESULT_UNDETERMINED = PREFIX + "아직 로또의 등수가 정해지지 않았습니다.";
    public static final String LOTTO_BONUS_NUMBER = PREFIX + "보너스 번호는 로또 번호에 포함될 수 없습니다";
    public static final String MONEY_NEG_NUM = PREFIX + "입력 금액은 음수일 수 없습니다.";
    public static final String MONEY_MIN_VALUE = PREFIX + "금액은 " + Rule.MONEY_MINIMUM_VALUE + "원 미만일 수 없습니다";
    public static final String MONEY_MIN_UNIT = PREFIX + "금액은 " + Rule.LOTTO_PRICE + "원 단위여야 합니다";

    // input 관련 exception
    public static final String INPUT_NULL = PREFIX + "입력값은 null 이나 공백이 될 수 없습니다";

    // parsing 관련 exception
    public static final String PARSE_LONG = PREFIX + "입력 값이 long 타입의 수로 변환될 수 없습니다.";
    public static final String PARSE_INT = PREFIX + "입력 값이 int 타입의 수로 변환될 수 없습니다.";
    public static final String PARSE_LIST_DELIMITER = PREFIX + "list 구분자가 유효하지 않습니다.";

    // repository 관련 exception
    public static final String REPOSITORY_NOT_FOUND = PREFIX + "해당 id 값이 존재하지 않습니다.";
    public static final String REPOSITORY_ID_NULL = PREFIX + "id는 null 이 될 수 없습니다.";
    public static final String REPOSITORY_VALUE_NULL = PREFIX + "value 는 null 이 될 수 없습니다.";

    private ExceptionName() {
    }
}
