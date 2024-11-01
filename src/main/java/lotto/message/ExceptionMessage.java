package lotto.message;

public enum ExceptionMessage {
    ERROR_TEST("[ERROR]"),
    ERROR_1_TO_45("[ERROR] 1부터 45 사이의 숫자를 입력해야 합니다."),
    ERROR_INPUT_TYPE_DELIMITER("[ERROR] 당첨 번호는 정수를 입력해야 하며 쉼표(,)로 구분해 입력해야 합니다."),
    ERROR_DUPLICATE("[ERROR] 중복된 값이 입력되었습니다."),
    ERROR_6("[ERROR] 로또 번호는 6개여야 합니다."),
    ERROR_EMPTY("[ERROR] 공백입니다."),
    ERROR_DIVIDE_1000("[ERROR] 1000으로 나누어 떨어지는 수여야 합니다."),
    ERROR_INTEGER_VALUE("[ERROR] 정수를 입력해야 합니다."),
    ERROR_NEGATIVE_NUMBER("[ERROR] 0보다 큰 수여야 합니다.");

    private final String errorDescription;

    ExceptionMessage(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
