package lotto.custom.validator;

public class CustomErrorMessages {
    public static final String NOT_DIVISIBLE_BY_THOUSAND = "[ERROR] 입력된 금액이 1000원으로 나누어 떨어지지 않습니다.";

    public static final String LOTTO_NUMBER_COUNT = "[ERROR] 로또 번호는 6개여야 합니다.";

    public static final String LOTTO_NUMBERS_MUST_BE_UNIQUE = "[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다.";

    public static final String LOTTO_NUMBER_OUT_OF_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static final String BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 달라야 합니다.";
}