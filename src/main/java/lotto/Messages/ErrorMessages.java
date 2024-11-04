package lotto.Messages;

public enum ErrorMessages {
    MONEY_UNIT("[ERROR] 구매 금액은 1,000원 단위여야 합니다."),
    MONEY_NEGATIVE("[ERROR] 구매 금액은 0보다 커야 합니다."),
    NUMBERS_SIZE("[ERROR] 당첨 번호는 6개여야 합니다."),
    NUMBERS_DUPLICATE("[ERROR] 당첨 번호에 중복된 숫자가 있습니다."),
    NUMBERS_RANGE("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    BONUS_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    SPACE_PREFIX("[ERROR] 입력값 앞에 공백이 있습니다."),
    SPACE_SUFFIX("[ERROR] 입력값 뒤에 공백이 있습니다."),
    SPACE_MIDDLE("[ERROR] 숫자 사이에 공백이 있습니다."),
    FORMAT_INVALID("[ERROR] 입력 형식이 올바르지 않습니다.");

    public final String message;

    ErrorMessages(String message) {
        this.message = message;
    }
}
