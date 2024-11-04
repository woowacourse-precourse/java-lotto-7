package lotto.common;

public class ErrorMessage {
    private static final String prefix = "[ERROR] ";

    // lotto
    public static final String lottoNumberSizeNot6 = prefix + "로또 번호는 6개여야 합니다.";
    public static final String lottoNumberDuplicated = prefix + "로또 번호가 중복입니다.";

    // input
    public static final String unknownError = prefix + "알 수 없는 에러가 발생했습니다.";
    public static final String cantDividedInto1000 = prefix + "입력값이 1000원 단위로 나눠떨어지지 않습니다.";
    public static final String numberParseError = prefix + "숫자로 파싱하는데 실패했습니다.";
}
