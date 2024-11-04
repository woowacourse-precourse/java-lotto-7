package lotto.constant;

public class LottoErrorMessage {
    private static final String ERROR_FORMAT = "[ERROR] %s";

    public static final String LOTTO_PRICE_ERROR = String.format(ERROR_FORMAT, "로또 구입 금액은 1,000원 단위로 입력 가능합니다.");
    public static final String LOTTO_NUMBER_RANGE_ERROR = String.format(ERROR_FORMAT, "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    public static final String LOTTO_WIN_NUMBER_COUNT_ERROR = String.format(ERROR_FORMAT, "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
}
