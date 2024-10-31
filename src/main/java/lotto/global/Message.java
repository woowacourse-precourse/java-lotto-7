package lotto.global;

public enum Message {

    PURCHASE_MESSAGE("구입금액을 입력해 주세요.");

    private String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
