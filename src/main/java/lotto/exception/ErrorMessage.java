package lotto.exception;

public enum ErrorMessage {

    NUMBER_SIZE_ERROR("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_CONTAINS_BONUS_NUMBER("[ERROR] 당첨 번호에 보너스 번호가 이미 존재합니다. 다시 입력해주세요."),
    NUMBER_RANGE_ERROR("[ERROR] 번호는 1~45 사이의 숫자만 가능합니다. 다시 입력해주세요."),
    DUPLICATE_NUMBER_ERROR("[ERROR] 로또 번호는 중복될 수 없습니다, 다시 입력해주세요."),
    MINIMUM_TICKET_PURCHASE_ERROR("[ERROR] 티켓은 적어도 한 장 이상 구매해야 합니다. 다시 입력해주세요."),
    INPUT_ONLY_NUMBER("[ERROR] 잘못된 입력입니다. 양의 정수를 입력해주세요."),
    PURCHASE_PRICE_DIVIDE_ERROR("[ERROR] 구입금액은 1000원 단위로만 가능합니다. 다시 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
