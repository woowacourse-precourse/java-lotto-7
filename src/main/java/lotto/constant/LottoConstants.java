package lotto.constant;

public class LottoConstants {

    public static final int LOTTO_PRICE_UNIT = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;

    public static final String ERROR_NON_INTEGER_AMOUNT = "[ERROR] 구입금액은 정수여야 합니다.";
    public static final String ERROR_AMOUNT_NOT_MULTIPLE_OF_UNIT = "[ERROR] 구입금액은 1,000원 단위여야 합니다.";
    public static final String ERROR_PURCHASE_AMOUNT_GREATER_THAN_ZERO = "[ERROR] 구입 금액은 0보다 커야 합니다.";
    public static final String ERROR_NON_INTEGER_LOTTO_NUMBER = "[ERROR] 로또 번호는 정수여야 합니다.";
    public static final String ERROR_INVALID_WINNING_NUMBER_COUNT = "[ERROR] 당첨 번호는 6개의 숫자여야 합니다.";
    public static final String ERROR_WINNING_NUMBER_OUT_OF_RANGE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_DUPLICATE_WINNING_NUMBER = "[ERROR] 당첨 번호는 중복되지 않아야 합니다.";
    public static final String ERROR_NON_INTEGER_BONUS_NUMBER = "[ERROR] 보너스 번호는 정수여야 합니다.";
    public static final String ERROR_BONUS_NUMBER_OUT_OF_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_DUPLICATE_BONUS_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";
    public static final String ERROR_DUPLICATE_LOTTO_NUMBER = "[ERROR] 로또 번호는 당첨 번호와 중복되지 않아야 합니다.";
    public static final String ERROR_INVALID_LOTTO_NUMBER_COUNT = "[ERROR] 당첨 번호는 6개의 숫자여야 합니다.";

    public static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String REQUEST_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    public static final String REQUEST_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    public static final String WINNING_NUMBER_DELIMITER = ",";

    public static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    public static final String WINNING_STATISTICS_HEADER = "\n당첨 통계";
    public static final String WINNING_STATISTICS_DIVIDER = "---";
    public static final String BONUS_STATISTICS_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n";
    public static final String REGULAR_STATISTICS_FORMAT = "%d개 일치 (%,d원) - %d개%n";
    public static final String RATE_EARNING_MESSAGE = "총 수익률은 %.1f%%입니다.";


    private LottoConstants() {
        // 인스턴스 생성 방지
    }
}
