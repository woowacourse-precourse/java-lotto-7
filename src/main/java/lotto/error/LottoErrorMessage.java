package lotto.error;

public enum LottoErrorMessage {

    MONEY_EXCEPTION("구입 금액은 1,000원의 배수여야 합니다.");

    private final String msg;

    LottoErrorMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
