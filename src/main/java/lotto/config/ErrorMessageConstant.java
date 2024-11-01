package lotto.config;

public class ErrorMessageConstant {
    private ErrorMessageConstant() {
    }

    private static final String SUFFIX = "[ERROR] ";

    // 입력 에러 메세지
    public static final String NON_NUMERIC_MESSAGE = SUFFIX + "유효한 숫자를 입력해주세요.";
}
