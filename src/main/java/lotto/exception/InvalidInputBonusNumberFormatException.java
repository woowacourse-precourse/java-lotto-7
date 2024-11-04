package lotto.exception;

public class InvalidInputBonusNumberFormatException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 보너스 번호 입력 형식이 잘못되었습니다.";

    public InvalidInputBonusNumberFormatException() {
        super(ERROR_MESSAGE);
    }
}
