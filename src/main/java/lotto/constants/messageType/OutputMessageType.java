package lotto.constants.messageType;

public enum OutputMessageType {

    OUTPUT_BUY_LOTTO_MESSAGE_GUIDE("개를 구매했습니다."),
    OUTPUT_WINNING_STATISTICS("\n당첨 통계\n---"),
    OUTPUT_WINNING_YIELD("총 수익률은 %.1f%%입니다."),
    OUTPUT_WINNING_NUMBER_CORRECT("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n"),
    OUTPUT_WINNING_NUMBER_CORRECT_BONUS("%d개 일치 (%s원) - %d개%n"),
    COMMA(","),
    NEW_LINE("\n");


    private final String message;

    OutputMessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
