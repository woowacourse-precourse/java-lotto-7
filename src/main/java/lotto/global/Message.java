package lotto.global;

public enum Message {

    BUY_LOTTO_MESSAGE("지불액을 입력해 주세요."),
    BUY_LOTTO_COUNT_MESSAGE("개를 구매했습니다."),
    WINNING_NUMBER_MESSAGE("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해 주세요.");


    private String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
