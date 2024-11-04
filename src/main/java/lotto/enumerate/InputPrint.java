package lotto.enumerate;

public enum InputPrint {
    INPUT_YOUR_BUDGET("구매금액을 입력해 주세요."),
    INPUT_WIN_NUMBER("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.");
    private String msg;

    InputPrint(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
