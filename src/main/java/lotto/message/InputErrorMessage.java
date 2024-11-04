package lotto.message;

public enum InputErrorMessage implements Message {

    PURCHASE_AMOUNT_EMPTY("구입금액이 입력되지 않았어요."),
    PURCHASE_AMOUNT_INVALID("구입금액에 숫자가 아닌 문자가 포함되어 있어요."),

    WINNING_NUMBERS_EMPTY("당첨 번호가 입력되지 않았어요."),
    WINNING_NUMBERS_INVALID("당첨 번호에 숫자와 쉼표가 아닌 문자가 포함되어 있어요."),

    BONUS_NUMBER_EMPTY("보너스 번호가 입력되지 않았어요."),
    BONUS_NUMBER_INVALID("보너스 번호는 숫자여야 해요."),
    ;

    private final String message;

    InputErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String get() {
        String format = "[ERROR] %s 다시 입력해주세요.";
        return String.format(format, message);
    }
}
