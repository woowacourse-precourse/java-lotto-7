package lotto.message;

public enum ErrorMessage implements MessageProvider {

    IS_BLANK_PURCHASE_AMOUNT("[ERROR] 구매 금액이 입력되지 않았습니다."),
    UNAVAILABLE_TYPE_PURCHASE_AMOUNT("[ERROR] 구매 금액이 숫자 형식이여야 합니다."),
    UNAVAILABLE_PURCHASE_AMOUNT("[ERROR] 구매금액은 1000원 단위로 입력이 가능합니다."),
    IS_BLANK_WINNING_LOTTO_NUMBERS("[ERROR] 당첨 번호가 입력되지 않았습니다."),
    UNAVAILABLE_LOTTO_NUMBERS("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    UNAVAILABLE_TYPE_LOTTO_NUMBERS("[ERROR] 입력한 로또 번호가 숫자 형식이 아닙니다."),
    UNAVAILABLE_LOTTO_NUMBERS_LENGTH("[ERROR] 로또 번호는 6개여야 합니다."),
    HAS_DUPLICATED_NUMBER_LOTTO("[ERROR] 로또번호에 중복이 있습니다."),
    HAS_DUPLICATED_BONUS_NUMBER("[ERROR] 당첨번호에 보너스 번호와 중복되는 숫자가 있습니다."),
    UNAVAILABLE_TYPE_BONUS_NUMBER("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.."),
    IS_BLANK_BONUS_NUMBER("[ERROR] 보너스 번호가 입력되지 않았습니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message =  message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
