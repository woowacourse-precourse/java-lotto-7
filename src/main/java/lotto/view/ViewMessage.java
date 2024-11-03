package lotto.view;

public enum ViewMessage {
    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    PRINT_TICKET_COUNT("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PRINT_WINNING_STATISTICS("당첨 통계"),
    PRINT_DIVIDER("---"),
    PRINT_MATCH_3("3개 일치 (5,000원) - %d개"),
    PRINT_MATCH_4("4개 일치 (50,000원) - %d개"),
    PRINT_MATCH_5("5개 일치 (1,500,000원) - %d개"),
    PRINT_MATCH_5_AND_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    PRINT_MATCH_6("6개 일치 (2,000,000,000원) - %d개"),
    PRINT_RETURN_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}