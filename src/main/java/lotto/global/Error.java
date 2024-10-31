package lotto.global;

public enum Error {

    NOT_INTEGER("[ERROR] 정수만 입력해야 합니다."),
    MONEY_NOT_POSITIVE("[ERROR] 구매 가격은 양의 정수여야만 합니다."),
    MONEY_NOT_DIVISIBLE_1000("[ERROR] 구매 가격은 1000으로 나누어 떨어져야 합니다.");

    private String errorMsg;

    Error(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
