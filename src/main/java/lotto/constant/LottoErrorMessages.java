package lotto.constant;

public class LottoErrorMessages {
    public static final String INVALID_INPUT_FORMAT = "[ERROR] 입력값이 숫자여야 합니다.";
    public static final String INVALID_PURCHASE_AMOUNT = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";
    public static final String INVALID_LOTTO_SIZE = "[ERROR] 번호의 개수는 6개여야 합니다.";
    public static final String NUMBER_OUT_OF_RANGE = "[ERROR] 번호는 1~45 사이의 숫자여야 합니다.";
    public static final String DUPLICATE_NUMBER = "[ERROR] 중복되지 않는 숫자여야 합니다.";
    public static final String BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";

    private LottoErrorMessages() {
    }
}