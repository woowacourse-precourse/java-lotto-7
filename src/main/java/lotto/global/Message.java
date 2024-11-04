package lotto.global;

public enum Message {

    BUY_LOTTO_MESSAGE("구입금액을 입력해 주세요."),
    BUY_LOTTO_COUNT_MESSAGE("개를 구매했습니다."),
    WINNING_NUMBER_MESSAGE("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해 주세요."),
    LOTTO_NUMBER_RESULT("\n당첨 통계\n---"),
    LOTTO_NUMBER_CORRECT_RESULT("%d개 일치 (%s원) - %d개"),
    LOTTO_BONUS_NUMBER_CORRECT_RESULT("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    LOTTO_PROFIT_RESULT("총 수익률은 %,.1f%%입니다.");

    private String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}