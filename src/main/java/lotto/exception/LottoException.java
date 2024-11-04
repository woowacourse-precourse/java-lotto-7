package lotto.exception;

public class LottoException extends IllegalArgumentException {
    public static final String INVALID_PURCHASE_AMOUNT = "[ERROR] 구입금액은 1,000원 단위여야 합니다.";
    public static final String LOWER_PURCHASE_AMOUNT = "[ERROR] 구입금액은 1,000원 이상이어야 합니다.";
    public static final String INVALID_LOTTO_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBER = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    public static final String DUPLICATE_LOTTO = "[ERROR] 중복된 로또가 존재합니다.";
    public static final String INVALID_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATE_BONUS_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";
    public static final String INVALID_NUMBER_FORMAT = "[ERROR] 숫자 형식이 올바르지 않습니다.";

    public LottoException(String message) {
        super(message);
    }
}
