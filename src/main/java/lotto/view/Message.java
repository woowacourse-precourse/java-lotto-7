package lotto.view;

public enum Message {

    INPUT_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    DISPLAY_LOTTO_BUY_COUNT_MESSAGE("%d개를 구매했습니다."),
    DISPLAY_LOTTO_INFO_MESSAGE("[%s]"),
    INPUT_LOTTO_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_LOTTO_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    DISPLAY_RESULT_TITLE_MESSAGE("당첨 통계"),
    DISPLAY_RESULT_TITLE_DIVIDER("---"),
    DISPLAY_RESULT_INFO("%d개 일치%s(%,d원) - %d개"),
    DISPLAY_PROFIT("총 수익률은 %s%%입니다.")
    ;

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public void printMessage(Object... values) {
        System.out.println(formatWith(values));
    }

    public String formatWith(Object... values) {
        return String.format(message, values);
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
