package lotto.global;

public enum Message {

    BUY_LOTTO_MESSAGE("지불액을 입력해 주세요.");

    private String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
