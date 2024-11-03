package lotto.view;

public enum SystemMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    LOTTO_QUANTITY("%d개를 구매했습니다.\n"),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요.");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
