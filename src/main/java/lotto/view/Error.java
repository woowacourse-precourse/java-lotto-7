package lotto.view;

public class Error {
    public static final String BASIC_MSG = "[ERROR] ";
    public static final String INVALID_MSG = "유효하지 않은 입력 값 입니다.";
    public static final String RANGE_MSG = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String MONEY_MSG = "1000 단위로 입력하셔야 합니다.";
    public static final String FIXED_COUNT_MSG = "로또 번호는 6개여야 합니다.";
    public static final String DUPLICATE_VALUE_MSG = "중복된 값은 입력하실 수 없습니다.";


    public static void reject(String msg) {
        throw new IllegalArgumentException(BASIC_MSG + msg);
    }
}
