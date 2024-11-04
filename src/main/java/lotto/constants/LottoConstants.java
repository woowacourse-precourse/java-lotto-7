package lotto.constants;

public class LottoConstants {
    public static final int LOTTO_SIZE = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_PURCHASE_AMOUNT = 1000;
    public static final int LOTTO_PRICE = 1000;

    public static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String RESULTS_HEADER = "당첨 통계";
    public static final String DIVIDER = "---";

    public static final String ERROR_INVALID_INPUT = "[ERROR] 유효하지 않은 입력입니다.";
    public static final String ERROR_LOTTO_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_PURCHASE_AMOUNT = "[ERROR] 금액은 1,000원 단위여야 합니다.";
    public static final String ERROR_INVALID_AMOUNT = "[ERROR] 금액은 숫자로 입력해야 하며, 1,000원 이상이어야 합니다.";
    public static final String ERROR_DUPLICATE_NUMBER = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    public static final String ERROR_BONUS_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    private LottoConstants() {
    }
}