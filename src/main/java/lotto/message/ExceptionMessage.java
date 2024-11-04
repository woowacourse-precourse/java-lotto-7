package lotto.message;

public class ExceptionMessage {
    public static final String PREFIX = "[ERROR] : ";
    public static final String INVALID_SIZE = "로또 숫자 개수는 6개입니다.";
    public static final String OUT_OF_RANGE_LOTTO_NUMBER = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBER = "로또 번호에 중복되는 숫자가 포함되어 있습니다.";
    public static final String NEGATIVE_NUMBER = "음수는 입력할 수 없습니다.";
    public static final String INVALID_UNIT = "로또 구입은 1,000원 단위로 가능합니다.";
    public static final String INPUT_NULL = "입력값이 없습니다.";
    public static final String NUMBER_FORMAT = "숫자를 입력해야 합니다.";

    private ExceptionMessage() {
        // 불필요한 인스턴스 생성 방지
    }
}