package lotto.common;

public final class ErrorMessage {

    public static final String INPUT_NOT_BLANK = "[ERROR] 입력값은 비어 있지 않아야 합니다.";
    public static final String INPUT_INTEGER = "[ERROR] 입력값은 정수여야 합니다.";
    public static final String PURCHASE_AMOUNT_POSITIVE = "[ERROR] 구입 금액은 양수여야 합니다.";
    public static final String PURCHASE_AMOUNT_THOUSAND_UNIT = "[ERROR] 구입 금액은 %d원 단위의 정수여야 합니다.".formatted(
            LottoConstants.LOTTO_PRICE);
    public static final String LOTTO_NUMBER_SIZE = "[ERROR] 로또 번호는 %d개여야 합니다.".formatted(LottoConstants.LOTTO_SIZE);
    public static final String LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 %d에서 %d 사이의 숫자여야 합니다.".formatted(
            LottoConstants.MIN_NUMBER, LottoConstants.MAX_NUMBER);
    public static final String LOTTO_NUMBER_DUPLICATE = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
    public static final String BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 %d에서 %d 사이의 숫자여야 합니다.".formatted(
            LottoConstants.MIN_NUMBER, LottoConstants.MAX_NUMBER);
    public static final String BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";

    private ErrorMessage() {
    }
}
