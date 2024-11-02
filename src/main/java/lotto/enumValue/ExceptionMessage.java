package lotto.enumValue;

public enum ExceptionMessage {
    ERROR_1_TO_45(CommonMessage.ERROR.getMessange() + " 1부터 45 사이의 숫자를 입력해야 합니다." + CommonMessage.NEW_LINE.getMessange()),
    ERROR_INPUT_TYPE_DELIMITER(CommonMessage.ERROR.getMessange() + " 당첨 번호는 정수를 입력해야 하며 쉼표(,)로 구분해 입력해야 합니다." + CommonMessage.NEW_LINE.getMessange()),
    ERROR_DUPLICATE(CommonMessage.ERROR.getMessange() + " 중복된 값이 입력되었습니다." + CommonMessage.NEW_LINE.getMessange()),
    ERROR_6(CommonMessage.ERROR.getMessange() + " 로또 번호는 6개여야 합니다." + CommonMessage.NEW_LINE.getMessange()),
    ERROR_EMPTY(CommonMessage.ERROR.getMessange() + " 공백입니다." + CommonMessage.NEW_LINE.getMessange()),
    ERROR_DIVIDE_1000(CommonMessage.ERROR.getMessange() + " 1000으로 나누어 떨어지는 수여야 합니다." + CommonMessage.NEW_LINE.getMessange()),
    ERROR_INTEGER_VALUE(CommonMessage.ERROR.getMessange() + " 정수를 입력해야 합니다." + CommonMessage.NEW_LINE.getMessange()),
    ERROR_NEGATIVE_NUMBER(CommonMessage.ERROR.getMessange() + " 0보다 큰 수여야 합니다." + CommonMessage.NEW_LINE.getMessange());

    private final String errorDescription;

    ExceptionMessage(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
