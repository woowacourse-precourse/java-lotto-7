package lotto.enums;

public enum OutputMessage {
    // 출력 메시지
    OUTPUT_WINNING_STATISTICS("당첨 통계"),
    OUTPUT_SECTION("---"),
    OUTPUT_3_MATCHES("3개 일치 (5,000원) - %d개"),
    OUTPUT_4_MATCHES("4개 일치 (50,000원) - %d개"),
    OUTPUT_5_MATCHES("5개 일치 (1,500,000원) - %d개"),
    OUTPUT_5_BONUS_MATCHES("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    OUTPUT_6_MATCHES("6개 일치 (2,000,000,000원) - %d개");

    private final String outputMessage;

    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage(Object... args) {
        return String.format(outputMessage, args);
    }
}
