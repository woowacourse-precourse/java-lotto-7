package lotto;

public class ExceptionMessage {
    public static final String ERROR_EMPTY_INPUT = "[ERROR] 빈 값이 입력되었습니다.";
    public static final String ERROR_INVALID_NUMBER = "[ERROR] 양수를 입력해주세요.";
    public static final String ERROR_INVALID_UNIT = "[ERROR] 천원 단위로 입력해주세요.";
    public static final String ERROR_INVALID_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String ERROR_DUPLICATE_NUMBER = "[ERROR] 로또 번호는 중복이 안됩니다.";
    public static final String ERROR_INVALID_RANGE = "[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.";
    public static final String ERROR_DUPLICATE_BONUS = "[ERROR] 당첨 번호와 중복되었습니다.";

    private ExceptionMessage() {
        // 인스턴스화 방지
    }
}
