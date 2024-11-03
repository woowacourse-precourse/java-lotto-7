package lotto.view.constants;

public enum ViewMessage {

    INPUT_LOTTO_PURCHASE_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    OUTPUT_LOTTO_PURCHASE_AMOUNT("%d개를 구매했습니다.\n"),
    OUTPUT_LOTTO_RESULT_HEADER("당첨 통계\n---"),
    OUTPUT_LOTTO_RESULT_BODY("%d개 일치 (%s원) - %d개"),
    OUTPUT_LOTTO_RESULT_BONUS_BODY("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    OUTPUT_TOTAL_PROFIT("총 수익률은 %.1f%%입니다."),
    ;

    private final String message;

    ViewMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
