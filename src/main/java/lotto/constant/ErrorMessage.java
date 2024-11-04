package lotto.constant;

public enum ErrorMessage {
    NULL_INPUT("[ERROR]: 입력값은 null이 될 수 없습니다."),
    INVALID_PURCHASE_AMOUNT("[ERROR]: 구매 금액은 [숫자] 또는 [+숫자]이 가능합니다."),
    WHITESPACE_IN_PURCHASE_AMOUNT("[ERROR]: 구입 금액 숫자 사이에 공백이 포함될 수 없습니다."),
    OUT_OF_RANGE_PURCHASE_AMOUNT("[ERROR]: 구입 금액은 0원에서 100,000원 사이여야 합니다."),
    NOT_DIVIDED_PURCHASE_AMOUNT("[ERROR]: 구입 금액은 1000원 단위로 가능합니다."),
    NOT_NUMBERS_AND_COMMAS_LOTTO_NUMBERS("[ERROR]: 로또 번호는 숫자와 쉼표만 입력 가능합니다."),
    INVALID_FORMAT_LOTTO_NUMBERS("[ERROR]: 로또 번호는 [숫자,숫자,숫자..] 형식만 가능합니다."),
    NOT_SIX_LOTTO_NUMBERS("[ERROR]: 로또 번호는 6개여야 합니다."),
    OUT_OF_RANGE_LOTTO_NUMBERS("[ERROR]: 로또 번호는 1부터 45사이의 숫자만 가능합니다."),
    DUPLICATED_LOTTO_NUMBER("[ERROR]: 로또 번호와 보너스 번호는 중복될 수 없습니다."),
    INVALID_FORMAT_BONUS_NUMBER("[ERROR]: 보너스 번호는 [+숫자] 또는 [숫자] 형식만 가능합니다.");



    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
