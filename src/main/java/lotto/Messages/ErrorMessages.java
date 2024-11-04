package lotto.Messages;

public enum ErrorMessages {
    MONEY_UNIT("구매 금액은 1,000원 단위여야 합니다."),
    MONEY_NEGATIVE("구매 금액은 0보다 커야 합니다."),
    NUMBERS_SIZE("당첨 번호는 6개여야 합니다."),
    NUMBERS_DUPLICATE("당첨 번호에 중복된 숫자가 있습니다."),
    NUMBERS_RANGE("당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_DUPLICATE("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    BONUS_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    SPACE_PREFIX("입력값 앞에 공백이 있습니다."),
    SPACE_SUFFIX("입력값 뒤에 공백이 있습니다."),
    SPACE_MIDDLE("숫자 사이에 공백이 있습니다."),
    FORMAT_INVALID("입력 형식이 올바르지 않습니다.");

    public final String message;

    ErrorMessages(String message) {
        this.message = message;
    }
}
