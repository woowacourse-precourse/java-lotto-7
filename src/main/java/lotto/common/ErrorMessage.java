package lotto.common;

public class ErrorMessage {
    private static final String prefix = "[ERROR] ";

    public static final String unknownError = "알 수 없는 에러가 발생했습니다.";
    public static final String cantDividedInto1000 = prefix + "입력값이 1000원 단위로 나눠떨어지지 않습니다.";
}
