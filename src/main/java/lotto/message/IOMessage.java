package lotto.message;

public enum IOMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    OUTPUT_PURCHASE_QUANTITY("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_WINNING_STATISTIC("당첨 통계\n---");
    private final String ioMessage;

    IOMessage(final String ioMessage) {
        this.ioMessage = ioMessage;
    }

    public String getMessage() {
        return ioMessage;
    }
}
