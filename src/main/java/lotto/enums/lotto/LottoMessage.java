package lotto.enums.lotto;

public enum LottoMessage {
    // print
    PRINT_INPUT_LOTTO_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PRINT_INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PRINT_INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),

    // exception
    EXCEPTION_NUMBER_VALID("[ERROR] 올바른 형식의 숫자가 아닙니다."),
    EXCEPTION_PRICE_UNIT("[ERROR] 1,000원 단위가 아닙니다."),
    EXCEPTION_NUMBER_RANGE("[ERROR] 숫자 범위를 초과했습니다.");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
