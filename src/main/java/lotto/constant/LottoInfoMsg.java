package lotto.constant;

public enum LottoInfoMsg {

    INPUT_PURCHASE_AMOUNT("구입 금액을 입력해 주세요."),
    START_PRINT_LOTTO_NUMBERS("%d개를 구매했습니다.");

    private final String msg;

    LottoInfoMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
