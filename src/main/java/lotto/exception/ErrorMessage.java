package lotto.exception;

public enum ErrorMessage {

    ERROR_INPUT_EMPTY_OR_NULL("[ERROR] 사용자 입력이 입력되지 않았습니다."),
    ERROR_BONUS_NUMBER_NOT_NUMERIC("[ERROR] 보너스 숫자는 오직 '숫자'만 입력 가능합니다."),
    ERROR_OUT_OF_RANGE("[ERROR] 당첨번호와 보너스번호는 1~45 사이의 숫자만 사용 가능합니다."),
    ERROR_BONUS_NUMBER_DUPLICATE("[ERROR] 당첨번호와 보너스번호는 중복되는 숫자가 존재해선 안됩니다."),
    ERROR_AMOUNT_NOT_DIVISIBLE_BY_THOUSAND("[ERROR] 로또 구매 금액은 1000원단위로 지불 가능합니다."),
   ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
