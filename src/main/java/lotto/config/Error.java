package lotto.config;

public enum Error {
    SUCCEED(""),

    INPUT_INVALID("올바르지 않은 입력입니다.\n"),
    INPUT_CANT_DIVIDED_BY_1000("1000원으로 나눠떨어지지 않습니다.\n"),
    INPUT_DUPLICATED_INT("중복되는 숫자가 있습니다.\n");


    private final String prefix = LottoConfig.ERROR_MESSAGE;
    private final String msg;

    Error(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return LottoConfig.errorMessage(msg);
    }
}
