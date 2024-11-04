package lotto.exception;

public class LottoExceptionMessage {

    //Lotto
    public static final String LOTTO_NUMBERS_COUNT_LIMIT = "로또 번호는 6개여야 합니다.";
    public static final String UNIQUE_LOTTO_NUMBERS = "로또 번호는 서로 달라야 합니다.";

    //LottoNumber
    public static final String LOTTO_NUMBERS_RANGE_RESTRICTION = "로또 번호는 1 ~ 45 사이여야 합니다.";

    //LottoProfitCalculator
    public static final String PROFIT_WITH_ZERO_AMOUNT = "로또 번호는 1 ~ 45 사이여야 합니다.";
    public static final String NATURAL_NUMBER_PAYMENT = "구매금액은 0보다 커야 합니다.";

    //LottoSalesService
    public static final String PAYMENT_DIVISIBLE_BY_THE_LOTTO_PRICE = "로또는 1000원 단위로 구입할 수 있습니다.";
    public static final String POSITIVE_OR_ZERO_QUANTITIES = "수량은 0 이상이어야 합니다.";
    public static final String QUANTITIES_LESS_THAN_INTEGER_MAX_VALUE = "수량은 Integer.MAX_VALUE 보다 클 수 없습니다.";
    public static final String PAYMENT_MORE_THAN_ZERO = "구입 금액은 0보다 커야 합니다.";

    //InputView
    public static final String INTEGER_PAYMENT = "구매 금액은 정수여야 합니다.";
    public static final String FORMATTED_WINNING_NUMBERS = "당첨 번호는 정수이며 쉼표(,)로만 구분되어야 합니다.";
    public static final String INTEGER_BONUS_NUMBER = "보너스 번호는 정수여야 합니다.";

    //Default
    public static final String THROWING_UNEXPECTED_EXCEPTION ="예기치 못한 예외가 발생하였습니다.";
}
