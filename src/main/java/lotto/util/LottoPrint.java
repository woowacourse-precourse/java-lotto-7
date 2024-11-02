package lotto.util;

public enum LottoPrint {

    ASK_PAYMENT("구입금액을 입력해 주세요."),
    ALERT_BUYING_NUMBER("개를 구매했습니다."),
    ASK_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    ALERT_START_STAT("당첨 통계\n---"),
    STAT_PREFIX_1st("6개 일치 (2,000,000,000원) - "),
    STAT_PREFIX_2nd("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    STAT_PREFIX_3rd("5개 일치 (1,500,000원) - "),
    STAT_PREFIX_4th("4개 일치 (50,000원) - "),
    STAT_PREFIX_5th("3개 일치 (5,000원) - "),
    STAT_SUFFIX("개");

    private final String message;

    LottoPrint(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}
