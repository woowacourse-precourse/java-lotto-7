package lotto.constants;

public class ErrorMessages {

    // 로또 번호 관련 에러
    public static final String LOTTO_NUMBER_OUT_OF_RANGE="[ERROR]로또 번호의 범위를 벗어납니다.";
    public static final String LOTTO_NUMBER_DUPLICATE = "[ERROR] 중복된 번호가 있습니다.";
    public static final String LOTTO_NUMBER_COUNT_INVALID = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String LOTTO_WINNING_NUMBER_COUNT_INVALID = "[ERROR] 당첨 번호는 6개여야 합니다.";

    // 보너스 번호 관련 에러
    public static final String BONUS_NUMBER_DUPLICATE_WITH_WINNING_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String BONUS_NUMBER_OUT_OF_RANGE = "[ERROR] 보너스 번호가 범위를 벗어납니다.";
    public static final String BONUS_NUMBER_REQUIRED = "[ERROR] 보너스 번호를 입력해주세요.";

    // 금액 관련 에러
    public static final String AMOUNT_MUST_BE_POSITIVE = "[ERROR] 금액은 0보다 커야 합니다.";
    public static final String AMOUNT_MUST_BE_DIVISIBLE_BY_1000 = "[ERROR] 1000으로 나누져야 합니다.";

    // 입력값 검증 관련 에러
    public static final String INPUT_MUST_BE_NUMBER = "[ERROR] 숫자를 입력하세요.";
    public static final String INPUT_NUMBERS_ONLY = "[ERROR] 숫자만 입력할 수 있습니다.";
}
