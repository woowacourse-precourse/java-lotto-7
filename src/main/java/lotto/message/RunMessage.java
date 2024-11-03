package lotto.message;

public enum RunMessage {
    INPUT_AMOUNT_MESSAGE("구입금액을 입력해 주세요.\n"),
    PRINT_LOTTO_COUNT("\n%d개를 구매했습니다.\n");


    private final String message;


    RunMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
