package lotto.constant;

public enum OutputMessage {

    PURCHASE_GUIDE("구입금액을 입력해 주세요."),
    PURCHASE_AMOUNT("%d개를 구매했습니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
