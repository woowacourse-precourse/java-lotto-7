package lotto;

public enum MessageCenter {
    ERROR("[ERROR] "),
    ERROR_NOTNULL("[ERROR] 기추첨결과가 존재합니다."),
    ERROR_NULL("[ERROR] 추첨결과 저장 과정에서 에러가 발생하였습니다.");

    private final String msg;

    private MessageCenter(String msg) {
        this.msg = msg;
    }

    public String get() {
        return this.msg;
    }
}
