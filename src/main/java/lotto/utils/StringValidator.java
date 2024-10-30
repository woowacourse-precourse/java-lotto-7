package lotto.utils;

public final class StringValidator {
    
    private StringValidator() {}
    
    public static final String EXCEPTION_MESSAGE_EMPTY =
            Constants.EXCEPTION_MESSAGE_PREFIX + " 빈칸입니다. 숫자를 입력하세요.";
    
    public static final String EXCEPTION_MESSAGE_BLANK =
            Constants.EXCEPTION_MESSAGE_PREFIX + " 공백(띄어쓰기) 없이 입력하세요.";
    
    public static final String EXCEPTION_MESSAGE_NO_DIGIT =
            Constants.EXCEPTION_MESSAGE_PREFIX + " 숫자를 입력하세요.";
    
    public static void validateEmpty(String lineToValidate) {
        if (lineToValidate.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_EMPTY);
        }
    }
    
    public static void validateHasBlank(String lineToValidate) {
        if (lineToValidate.contains(" ")) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_BLANK);
        }
    }
    
    public static void validateOnlyDigits(String lineToValidate) {
        if (!lineToValidate.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_NO_DIGIT);
        }
    }
    
}
