package lotto.constant;

public class LottoErrorMessage {
    private static final String ERROR_FORMAT = "[ERROR] %s";

    public static final String LOTTO_PRICE_ERROR = String.format(ERROR_FORMAT, "로또 구입 금액은 1,000원 단위로 입력 가능합니다.");
    public static final String LOTTO_PRICE_FORMAT_ERROR = String.format(ERROR_FORMAT, "로또 구입 금액은 2^31보다 작은 정수만 입력되어야 합니다.");

    public static final String LOTTO_NUMBER_RANGE_ERROR = String.format(ERROR_FORMAT, "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    public static final String LOTTO_NUMBER_DUPLICATE_ERROR = String.format(ERROR_FORMAT, "로또 번호는 중복될 수 없습니다.");
    public static final String LOTTO_WIN_NUMBER_FORMAT_ERROR = String.format(ERROR_FORMAT, "로또 번호는 ','로 구분된 숫자 6개로 입력되어야 합니다.");
    public static final String LOTTO_BONUS_NUMBER_FORMAT_ERROR = String.format(ERROR_FORMAT, "로또 보너스 번호는 숫자 1개여야 합니다.");
}
