package lotto;

public enum Message {

    PURCHASE_PRICE("구입금액을 입력해 주세요."),
    WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    PURCHASE_QUANTITY("개를 구매했습니다."),
    WINNING_STATISTICS("\n당첨 통계\n---"),
    INPUT_TYPE_NUMBER_ERROR("[ERROR] 입력 형식은 숫자여야 합니다."),
    INPUT_NUMBER_PRICE_PER_LOTTO_ERROR("[ERROR] 잘못된 값을 입력하였습니다. 구입 금액은 1,000원 단위로 입력해 주세요"),
    INPUT_NUMBER_OF_LOTTO_ERROR("[ERROR] 로또 번호는 6개여야 합니다."),
    INPUT_NUMBER_DUPLICATION_ERROR("[ERROR] 로또 번호는 중복될 수 없습니다.");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
