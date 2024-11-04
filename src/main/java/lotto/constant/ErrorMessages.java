package lotto.constant;

public class ErrorMessages {

    public static final String INVALID_LOTTO_NUMBER = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String INVALID_MONEY = "구입금액은 1,000 단위의 양의 정수여야 합니다.";
    public static final String LOTTO_NUMBER_COUNT_ERROR = "로또 번호는 정확히 6개여야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBER_ERROR = "로또 번호는 중복될 수 없습니다.";

    private ErrorMessages() {
    }
}
