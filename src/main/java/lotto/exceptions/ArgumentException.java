package lotto.exceptions;

public class ArgumentException extends IllegalArgumentException {
    enum Error {
        INVALID_LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
        DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복되지 않는 숫자 6개여야 합니다."),
        INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
        INVALID_MONEY_UNIT("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다."),
        DUPLICATE_BONUS_BALL("[ERROR] 보너스 번호는 입력한 당첨 번호 6개와 중복되지 않는 숫자여야 합니다."),
        NOT_NUMBER("[ERROR] 숫자만 입력 가능합니다."),
        NOT_NUMBER_AND_COMMA("[ERROR] 숫자와 쉼표만 입력 가능합니다."),
        EMPTY_INPUT_VALUE("[ERROR] 값을 입력해 주세요."),
        INVALID_MONEY_RANGE("[ERROR] 금액은 양수를 입력해 주세요.");

        public final String message;

        Error(final String message) {
            this.message = message;
        }
    }

    public static final ArgumentException INVALID_LOTTO_SIZE = new ArgumentException(Error.INVALID_LOTTO_SIZE.message);
    public static final ArgumentException DUPLICATE_LOTTO_NUMBER = new ArgumentException(Error.DUPLICATE_LOTTO_NUMBER.message);
    public static final ArgumentException INVALID_LOTTO_NUMBER_RANGE = new ArgumentException(Error.INVALID_LOTTO_NUMBER_RANGE.message);
    public static final ArgumentException INVALID_MONEY_UNIT = new ArgumentException(Error.INVALID_MONEY_UNIT.message);
    public static final ArgumentException DUPLICATE_BONUS_BALL = new ArgumentException(Error.DUPLICATE_BONUS_BALL.message);
    public static final ArgumentException ONLY_NUMBER = new ArgumentException(Error.NOT_NUMBER.message);
    public static final ArgumentException ONLY_NUMBER_AND_COMMA = new ArgumentException(Error.NOT_NUMBER_AND_COMMA.message);
    public static final ArgumentException EMPTY_INPUT_VALUE = new ArgumentException(Error.EMPTY_INPUT_VALUE.message);
    public static final ArgumentException INVALID_MONEY_RANGE = new ArgumentException(Error.INVALID_MONEY_RANGE.message);

    public ArgumentException(final String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
