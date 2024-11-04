package lotto.error;

public enum ErrorMessage {
    INVALID_PURCHASE_PRICE("구입 금액은 1,000원 단위이어야 합니다."),
    INVALID_PURCHASE_PRICE_FORMAT("구입 금액은 숫자이어야 합니다."),
    INVALID_WINNING_LOTTO_NUMBER_COUNT("당첨 번호의 개수는 6개이어야 합니다."),
    DUPLICATE_WINNING_LOTTO_NUMBER("당첨 번호들은 중복될 수 없습니다."),
    INVALID_WINNING_LOTTO_NUMBER_RANGE("당첨 번호들은 1부터 45 사이의 숫자이어야 합니다."),
    MISSING_WINNING_LOTTO_NUMBER("당첨 번호를 입력하지 않았습니다. 쉼표로 구분된 6개의 숫자를 입력해 주세요."),
    INVALID_WINNING_LOTTO_NUMBER_FORMAT("당첨 번호는 쉼표(,)로 구분된 6개의 숫자로 입력해야 합니다."),
    INVALID_BONUS_NUMBER_RANGE("보너스 번호는 1부터 45 사이의 숫자이어야 합니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_BONUS_NUMBER_FORMAT("보너스 번호는 숫자이어야 합니다."),
    MISSING_BONUS_NUMBER("보너스 번호를 입력하지 않았습니다. 보너스 번호를 입력해 주세요,");

    private static final String ERROR_MESSAGE_HEADER = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = ERROR_MESSAGE_HEADER + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
