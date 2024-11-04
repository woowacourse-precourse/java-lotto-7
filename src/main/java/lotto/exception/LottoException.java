package lotto.exception;

public enum LottoException {

    COUNT_OF_WINNING_NUMBER_IS_NOT_SIX("당첨 번호는 총 6개입니다. 6개의 자연수를 입력해주세요."),
    INVALID_RANGE_OF_LOTTERY_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다."),

    PURCHASE_AMOUNT_IS_ZERO("입력한 로또 구입 금액이 0입니다."),
    PURCHASE_AMOUNT_IS_NEGATIVE("입력한 로또 구입 금액이 음수입니다."),
    PURCHASE_AMOUNT_IS_INVALID("로또 1장의 구입 금액은 1000원입니다. 1000원으로 나누어 떨어지는 금액을 입력해주세요."),

    PURCHASE_AMOUNT_IS_EMPTY("구입 금액을 입력해주세요."),
    WINNING_NUMBER_IS_EMPTY("당첨 번호를 입력해주세요."),
    BONUS_NUMBER_IS_EMPTY("보너스 번호를 입력해주세요.");

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    private final String errorMessage;

    LottoException(String errorMessage) {
        this.errorMessage = ERROR_MESSAGE_PREFIX + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
