package lotto.enums;

public enum ErrorMessage implements MessageProvider {
    INPUT_BLANK_ERROR("입력값이 없습니다."),
    INPUT_NOT_NUMBER_ERROR("숫자만 입력 가능합니다."),
    INPUT_NUMBER_NOT_DIVISIBLE_BY_1000("1,000 단위로 입력해주세요."),
    INVALID_DELIMITER_AND_NUMBER("숫자와 콤마(,)가 올바르게 배치되어야 합니다."),
    INPUT_NOT_BETWEEN_ONE_AND_FORTYFIVE("1부터 45까지의 숫자만 입력해주세요"), 
    INPUT_NUMBER_DUPLICATE_ERROR("중복된 숫자가 존재합니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개를 입력해주세요.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return PREFIX + message;
    }
}
