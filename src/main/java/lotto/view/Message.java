package lotto.view;

import lotto.model.Rank;

public enum Message {

    INPUT_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    DISPLAY_LOTTO_BUY_COUNT_MESSAGE("%d개를 구매했습니다."),
    DISPLAY_LOTTO_INFO_MESSAGE("[%s]"),
    INPUT_LOTTO_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_LOTTO_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    DISPLAY_RESULT_TITLE_MESSAGE("당첨 통계"),
    DISPLAY_RESULT_TITLE_DIVIDER("---"),
    DISPLAY_RESULT_INFO_NOT_BONUS("%d개 일치 (%,d원) - %d개"),
    DISPLAY_RESULT_INFO_BONUS("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    DISPLAY_PROFIT("총 수익률은 %.1f%%입니다.")
    ;

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public void print(Object... values) {
        System.out.println(format(values));
    }

    public String format(Object... values) {
        return String.format(message, values);
    }

    public static String getResultInfo(int rank, Object... values) {
        if (rank == Rank._2TH.getRank()) {
            return DISPLAY_RESULT_INFO_BONUS.format(values);
        }
        return DISPLAY_RESULT_INFO_NOT_BONUS.format(values);
    }
}
