package lotto;

public enum MessageCenter {
    START("구입금액을 입력해 주세요."),
    COUNT("개를 구매했습니다."),
    ERROR("[ERROR] "),
    ERROR_NOTNULL("[ERROR] 기추첨결과가 존재합니다."),
    ERROR_NULL("[ERROR] 추첨결과 저장 과정에서 에러가 발생하였습니다."),
    ERROR_MONEY("[ERROR] 금액을 잘못 입력했습니다. 다시 입력해 주세요."),
    ERROR_USERSTORAGE("[ERROR] 구매기록이 없습니다.");


    private final String msg;

    private MessageCenter(String msg) {
        this.msg = msg;
    }

    public String get() {
        return this.msg;
    }

    public void print() {
        System.out.println(this.msg);
    }
}
