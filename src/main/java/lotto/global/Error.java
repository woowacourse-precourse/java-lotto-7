package lotto.global;

public enum Error {

    NOT_INTEGER("[ERROR] 정수만 입력해야 합니다."),
    MONEY_NOT_POSITIVE("[ERROR] 구매 가격은 양의 정수여야만 합니다."),
    MONEY_NOT_DIVISIBLE_1000("[ERROR] 구매 가격은 1000으로 나누어 떨어져야 합니다."),
    LOTTO_NUMBER_COUNT_IS_NOT_SIX("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_IS_DUPLICATED("[ERROR] 로또 번호는 서로 중복되면 안됩니다."),
    LOTTO_NUMBER_IS_NOT_BETWEEN_1_AND_46("[ERROR] 로또 번호는 1과 46 사이의 번호이어야 합니다.");


    private String errorMsg;

    Error(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
