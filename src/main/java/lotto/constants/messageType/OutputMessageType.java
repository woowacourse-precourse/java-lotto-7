package lotto.constants.messageType;

public enum OutputMessageType {

    OUTPUT_BUY_LOTTO_MESSAGE_GUIDE("개를 구매했습니다."),
    OUTPUT_WINNING_STATISTICS("\n당첨 통계\n---");

    private final String message;

    OutputMessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
