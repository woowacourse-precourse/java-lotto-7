package lotto.view.output;

public enum OutputMessage {
    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    PURCHASED_COUNT("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계\n---"),
    PROFIT("총 수익률은 %,.1f%%입니다.");
    final String message;

    OutputMessage(String message) {
        this.message = message;
    }

}
