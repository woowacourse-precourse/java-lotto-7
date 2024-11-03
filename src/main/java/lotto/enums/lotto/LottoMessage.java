package lotto.enums.lotto;

public enum LottoMessage {
    // print
    PRINT_LOTTO_PARChASE_AMOUNT("구입금액을 입력해 주세요.");

    // error

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
