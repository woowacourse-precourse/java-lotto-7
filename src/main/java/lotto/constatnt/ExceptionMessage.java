package lotto.constatnt;

public enum ExceptionMessage {
    PURCHASE_PRICE_BLANK_INPUT("[ERROR] 로또 구입 금액은 빈 값이 될 수 없습니다."),
    PURCHASE_PRICE_NOT_NUMBER("[ERROR] 로또 구입 금액은 숫자를 입력해주세요."),
    PURCHASE_PRICE_NEGATIVE_NUMBER("[ERROR] 로또 구입 금액은 양수를 입력해주세요."),
    PURCHASE_PRICE_UPPER_LIMIT("[ERROR] 로또 구입 금액은 1억 미만이어야 합니다."),
    PURCHASE_PRICE_NOT_MULTIPLE_OF_THOUSAND("[ERROR] 로또 구입 금액은 1000단위로 입력해야 합니다."),
    WINNING_NUMBER_OUT_OF_RANGE("[ERROR] 당첨 번호는 1~45 사이의 숫자여야 합니다."),
    WINNING_NUMBER_DUPLICATE("[ERROR] 당첨 번호에 중복된 숫자가 있습니다."),
    WINNING_NUMBER_BLANK_INPUT("[ERROR] 당첨 번호는 빈 값이 될 수 없습니다."),
    WINNING_NUMBER_NOT_NUMBER("[ERROR] 당첨 번호는 숫자로만 입력해주세요."),
    WINNING_NUMBER_SIZE_INSUFFICIENT("[ERROR] 당첨 번호는 6개를 입력해주세요."),
    BONUS_NUMBER_BLANK_INPUT("[ERROR] 보너스 번호는 빈 값이 될 수 없습니다."),
    BONUS_NUMBER_OUT_OF_RANGE("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE_WITH_WINNING("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    BONUS_NUMBER_NOT_NUMBER("[ERROR] 보너스 번호는 숫자로만 입력해주세요."),
    LOTTO_NUMBER_SIZE_INSUFFICIENT("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_DUPLICATE_NUMBER("[ERROR] 로또 번호에는 중복된 숫자가 있을 수 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
