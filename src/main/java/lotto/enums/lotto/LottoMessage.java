package lotto.enums.lotto;

public enum LottoMessage {
    // print
    PRINT_LOTTO_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PRINT_BONUS_NUMBER("보너스 번호를 입력해주세요.");

    // error

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
