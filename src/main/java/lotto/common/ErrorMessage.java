package lotto.common;

public class ErrorMessage {
    public static final String NOT_POSITIVE_INPUT ="[ERROR] 입력은 양의 정수이어야 합니다";
    public static final String BLANK_OR_NULL_INPUT = "[ERROR] 입력은 공백일 수 없습니다";
    public static final String NOT_UNIT_INPUT = "[ERROR] 구입 금액은 1000 단위이어야 합니다";
    public static final String INVALID_COUNT = "[ERROR] 로또 번호는 여섯개여야 합니다.";
    public static final String INVALID_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다";
    public static final String DUPLICATED_NUMBER = "[ERROR] 로또 번호는 서로 다른 숫자여야 합니다.";
    public static final String DUPLICATED_TO_WINNING_NUMBERS ="[ERROR] 보너스 번호는 당첨 번호와 달라야 합니다" ;
    public static final String INVALID_INPUT_TYPE ="[ERROR] 쉼표와 숫자만 입력할 수 있으며 숫자는 정수 범위이어야 합니다" ;
    public static final String INVALID_BONUS_NUMBER_TYPE="[ERROR] 보너스 번호는 숫자만 입력할 수 있으며 숫자는 정수 범위이어야 합니다";
    public static final String INVALID_PAYMENT_TYPE="[ERROR] 금액은 숫자만 입력할 수 있으며 숫자는 정수 범위이어야 합니다";
    public static final String INVALID_BONUS_NUMBER_RANGE="[ERROR] 보너스 번호는 1부터 45 사이의 숫지여야 합니다";
    public static final String INVALID_START_END_POINT = "[ERROR] 당첨 번호 입력의 시작 또는 끝은 쉼표일 수 없습니다";
}
