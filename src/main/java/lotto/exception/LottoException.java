package lotto.exception;

public enum LottoException {
    NUMBER_FORMAT_NOT_VALID("[ERROR] 숫자만 입력 가능합니다."),
    PURCHASE_AMOUNT_NOT_VALID("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    LOTTO_LENGTH_NOT_VALID("[ERROR] 로또 번호는 6자리로 입력해주세요."),
    LOTTO_RANGE_NOT_VALID("[ERROR] 로또 번호는 1~45 사이만 입력 가능합니다."),
    WINNING_NUMBERS_DUPLICATED("[ERROR] 당첨 번호 중 중복되는 값은 있을 수 없습니다."),
    BONUS_NUMBER_DUPLICATED("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.")
    ;

    private final String message;

    LottoException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
