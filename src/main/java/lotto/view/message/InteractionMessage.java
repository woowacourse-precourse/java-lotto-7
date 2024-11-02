package lotto.view.message;

public enum InteractionMessage {
    // TODO: 문장으로 읽히는 enum 이름
    // TODO: i/o 출력문 여기 다 때려박아도 되나?
    ENTER_MONEY("구입금액을 입력해 주세요."),
    ENTER_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASE_AMOUNT("%d개를 구매했습니다."),
    WINNING_STATISTICS("당첨 통계"),
    SEPARATOR("---"),
    THREE_MATCHES("3개 일치 (5,000원) - %d개"),
    FOUR_MATCHES("4개 일치 (50,000원) - %d개"),
    FIVE_MATCHES("5개 일치 (1,500,000원) - %d개"),
    FIVE_BONUS_MATCHES("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX_MATCHES("6개 일치 (2,000,000,000원) - %d개"),
    TOTAL_RETURN("총 수익률은 %.1f%%입니다.");

    private final String message;

    InteractionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
