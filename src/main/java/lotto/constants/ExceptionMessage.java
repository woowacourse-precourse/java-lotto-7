package lotto.constants;

public class ExceptionMessage {
    public static final String INVALID_PURCHASE_AMOUNT = "[ERROR] 구매 금액은 1000원 이상이어야 합니다.";
    public static final String INVALID_PURCHASE_AMOUNT_UNIT = "[ERROR] 구매 금액은 1000원 단위로만 입력할 수 있습니다.";
    public static final String NOT_A_NUMBER = "[ERROR] 구분자를 제외한 입력값은 숫자만 올 수 있습니다.";
    public static final String INVALID_LOTTO_NUMBER_COUNT = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1~45 사이어야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBER = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    public static final String LOTTO_NUMBER_NOT_EMPTY = "[ERROR] 로또 번호는 비어있을 수 없습니다.";
}
