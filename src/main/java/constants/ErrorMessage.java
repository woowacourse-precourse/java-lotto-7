package constants;

public class ErrorMessage {

    private ErrorMessage() {
        throw new IllegalArgumentException("인스턴스화 금지");
    }

    public static final String NOT_MATCH_LOTTO_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String EXISTS_DUPLICATE_NUMBER = "[ERROR] 로또 번호에 중복된 숫자가 존재합니다.";
    public static final String INVALID_PURCHASE_AMOUNT = "[ERROR] 구매 금액은 숫자로 입력해야 합니다.";
    public static final String UNDIVIDED_THOUSAND = "[ERROR] 구매 금액은 1000원 단위로 입력해야 합니다.";
    public static final String INVALID_NUMBER_RANGE = "[ERROR] 로또 번호는 1에서 45 사이 숫자여야 합니다.";
    public static final String ENTERED_INVALID_NUMBER = "[ERROR] 유효하지 않은 입력입니다.";
    public static final String DUPLICATE_BONUS_NUMBER = "[ERROR] 보너스 번호는 당첨 번호와 중복일 수 없습니다.";
}
