package lotto.constant;

public class ExceptionMessage {

    public static final String INVALID_LOTTO_SIZE_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String OUT_OF_RANGE_NUMBER_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATE_NUMBER_ERROR = "[ERROR] 중복된 숫자는 입력할 수 없습니다.";
    public static final String DUPLICATE_WINNING_AND_BONUS_ERROR  = "[ERROR] 당첨번호와 보너스 번호는 중복 될 수 없습니다.";

    //input
    public static final String MAX_AMOUNT_ERROR = "[ERROR] 1억원 이하의 숫자를 입력해주세요.";
    public static final String INVALID_PURCHASE_AMOUNT_ERROR = "[ERROR] 1,000원 단위의 금액을 입력해주세요.";
    public static final String INVALID_LOTTO_NUMBERS_FORMAT_ERROR = "[ERROR] 쉼표(,)로 구분된 45이하의 숫자 6개를 입력해주세요.";
    public static final String INVALID_NUMBER_FORMAT_ERROR = "[ERROR] 2자리 이하의 숫자를 입력해 주세요";

}
