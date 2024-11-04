package lotto.constants;

public enum ViewMessage {
    INPUT_BUY_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WIN_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해 주세요."),
    BUY_LOTTO_COUNT_MESSAGE("\n{0}개를 구매했습니다."),
    WIN_INFORMATION_MESSAGE("{0}개 일치 ({1}원) - {2}개"),
    WIN_SECOND_INFORMATION_MESSAGE("{0}개 일치, 보너스 볼 일치 ({1}원) - {2}개"),
    WIN_ALARM_MESSAGE("\n당첨 통계\n---"),
    TOTAL_PROFIT_MESSAGE("총 수익률은 {0}%입니다.");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
