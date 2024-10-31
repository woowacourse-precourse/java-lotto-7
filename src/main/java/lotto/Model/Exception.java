package lotto.Model;

public enum Exception {
    INVALID_NUMBER_COUNT("로또 번호는 6자리 숫자여야 합니다."),
    DUPLICATE_NUMBER("당첨 번호가 중복되지 않아야 합니다."),
    MONEY_IS_NOT_1000UNIT("구입 금액이 1000원 단위여야 합니다."),
    MONEY_IS_NOT_INTEGER("구입 금액은 정수여야 합니다."),
    INVALID_NUMBER_RANGE("로또 번호는 1부터 45사이의 숫자여야 합니다."),
    INVALID_NUMBER_TYPE("로또 번호는 정수여야 합니다."),
    EXIST_NUMBER("보너스 번호는 당첨 번호와 중첩되지 않아야 합니다.")
    ;


    private final String errorMessage;

    Exception(String errorMessage) {
        this.errorMessage = "[ERROR]" + errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
