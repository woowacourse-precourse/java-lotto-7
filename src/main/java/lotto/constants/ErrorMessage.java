package lotto.constants;

public abstract class ErrorMessage {
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String INVALID_NUMBER_FORMAT = "로또 구입 금액은 오직 숫자만 입력가능합니다.";
    public static final String NOT_ABLE_TO_PURCHASE = "구입 금액은 1,000원 단위여야 합니다.";
    public static final String INVALID_DELIMITER = "번호는 ','를 기준으로 입력해주세요.";
    public static final String INVALID_RANGE = "로또 번호는 1~45 까지만 입력이 가능합니다.";
    public static final String INVALID_DUPLICATE = "당첨 번호의 숫자 중복은 허용하지 않습니다.";
    public static final String NOT_ENOUGH_SIZE = "당첨 번호는 6개의 숫자여야 합니다.";
}
