package lotto.error;

public enum InputError {

    PURCHASE_AMOUNT_EMPTY("구입금액을 입력되지 않았어요. 다시 입력해주세요."),
    PURCHASE_AMOUNT_INVALID("구입금액에 숫자가 아닌 문자가 포함되어 있어요. 다시 입력해주세요."),
    PURCHASE_AMOUNT_UNDER_BASE_LIMIT("구입금액이 최소 구입금액보다 작아요. 다시 입력해주세요."),
    PURCHASE_AMOUNT_UNIT_INVALID("구입금액은 1000원 단위여야 해요. 다시 입력해주세요."),

    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 1과 45 사이의 숫자여야 해요. 다시 입력해주세요."),
    LOTTO_NUMBER_INVALID("로또 번호에 숫자가 아닌 문자가 포함되어 있어요. 다시 입력해주세요."),

    WINNING_NUMBERS_EMPTY("당첨 번호가 입력되지 않았어요. 다시 입력해주세요."),
    WINNING_NUMBERS_COUNT("당첨 번호는 6개여야 해요. 다시 입력해주세요."),
    WINNING_NUMBERS_DUPLICATE("당첨 번호에 중복된 숫자가 포함되어 있어요. 다시 입력해주세요."),
    WINNING_NUMBERS_INVALID("당첨 번호에 숫자와 쉼표가 아닌 문자가 포함되어 있어요. 다시 입력해주세요."),

    BONUS_NUMBER_EMPTY("보너스 번호가 입력되지 않았어요. 다시 입력해주세요."),
    BONUS_NUMBER_DUPLICATE("당첨 번호와 보너스 번호가 중복될 수 없어요. 다시 입력해주세요."),
    ;

    private final String message;

    InputError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
